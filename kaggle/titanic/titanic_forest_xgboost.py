# _*_ coding:utf-8 _*_

import pandas as pd

from sklearn.feature_extraction import DictVectorizer
from sklearn.ensemble import RandomForestClassifier
from sklearn.cross_validation import cross_val_score
from sklearn.grid_search import GridSearchCV

from xgboost import XGBClassifier

source_train = pd.read_csv('/root/Documents/play/_kaggle/_titanic/train.csv')
source_test = pd.read_csv('/root/Documents/play/_kaggle/_titanic/test.csv')
print '训练集数据：', source_train.shape
print '测试集数据：', source_test.shape

print source_train.info()

selected_features = ['Pclass', 'Sex', 'Age', 'Embarked', 'SibSp', 'Parch', 'Fare']

X_train = source_train[selected_features]
X_test = source_test[selected_features]
y_train = source_train['Survived']

# 对缺失的类别型的特征，习惯使用高频特征填充
X_train['Embarked'].fillna('S', inplace=True)
X_test['Embarked'].fillna('S', inplace=True)

# 对缺失的数值型的特征，习惯用均值或中位数填充
X_train['Age'].fillna(X_train['Age'].mean(), inplace=True)
X_test['Age'].fillna(X_train['Age'].mean(), inplace=True)
X_test['Fare'].fillna(X_train['Fare'].mean(), inplace=True)

dict_vec = DictVectorizer(sparse=False)
X_train = dict_vec.fit_transform(X_train.to_dict(orient='record'))
# print dict_vec.feature_names_
X_test = dict_vec.transform(X_test.to_dict(orient='record'))

rfc = RandomForestClassifier()
xgbc = XGBClassifier()

# 使用5折交叉验证进行性能评估
print cross_val_score(rfc, X_train, y_train, cv=5).mean()
print cross_val_score(xgbc, X_train, y_train, cv=5).mean()

# 使用RandomForest训练预测
rfc.fit(X_train, y_train)
rfc_y_predict = rfc.predict(X_test)
rfc_submission = pd.DataFrame({'PassengerId': source_test['PassengerId'], 'Survived': rfc_y_predict})
rfc_submission.to_csv('/root/Documents/rfc_submission.csv', index=False)

# 使用XGBC训练预测
xgbc.fit(X_train, y_train)
xgbc_y_predict = xgbc.predict(X_test)
xgbc_submission = pd.DataFrame({'PassengerId': source_test['PassengerId'], 'Survived': xgbc_y_predict})
xgbc_submission.to_csv('/root/Documents/xgbc_submission.csv', index=False)

# 使用并行格网搜索来优化超参数
params = {'max_depth': range(2, 7), 'n_estimators': range(100, 1100, 200), 'learning_rate': [0.05, 0.1, 0.25, 0.5, 1.0]}
xgbc_best = XGBClassifier()
gs = GridSearchCV(xgbc_best, params, n_jobs=1, cv=5, verbose=1)
gs.fit(X_train, y_train)
print gs.best_score_
print gs.best_params_
xgbc_best_y_predict = gs.predict(X_test)
xgbc_best_submission = pd.DataFrame({'PassengerId': source_test['PassengerId'], 'Survived': xgbc_best_y_predict})
xgbc_best_submission.to_csv('/root/Documents/xgbc_best_submission.csv', index=False)
