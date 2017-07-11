# _*_ coding:utf-8 _*_
import numpy as np
import pandas as pd

from sklearn.datasets import load_digits
from sklearn.cross_validation import train_test_split
from sklearn.feature_extraction import DictVectorizer
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import classification_report
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier

titanic = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/Titanic/titanic.txt')
print titanic.shape
print titanic.columns
# print titanic.head(2)
# print titanic.info()

X = titanic[['pclass', 'age', 'sex']]
y = titanic['survived']

# 用均值补充缺失年龄
X['age'].fillna(X['age'].mean(), inplace=True)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=33)
print len(y_train)
print len(y_test)

# 类别型特征剥离，数值型不变
vec = DictVectorizer(sparse=False)
X_train = vec.fit_transform(X_train.to_dict(orient='record'))
X_test = vec.transform(X_test.to_dict(orient='record'))
print vec.feature_names_

# 使用单一决策树模型训练
dtc = DecisionTreeClassifier()
dtc.fit(X_train, y_train)
dtc_y_predict = dtc.predict(X_test)

print '单一决策树预测结果的准确度是：', dtc.score(X_test, y_test)
print classification_report(dtc_y_predict, y_test, target_names=['died', 'survived'])

rfc = RandomForestClassifier()
rfc.fit(X_train,y_train)
rfc_y_predict = rfc.predict(X_test)

print '随机森林分类器预测结果的准确度是：', rfc.score(X_test, y_test)
print classification_report(rfc_y_predict, y_test, target_names=['died', 'survived'])

gbc = GradientBoostingClassifier()
gbc.fit(X_train,y_train)
gbc_y_predict=gbc.predict(X_test)

print '梯度提升决策树预测结果的准确度是：', gbc.score(X_test, y_test)
print classification_report(gbc_y_predict, y_test, target_names=['died', 'survived'])
