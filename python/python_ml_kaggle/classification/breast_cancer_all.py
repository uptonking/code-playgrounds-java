# _*_ coding:utf-8 _*_

import numpy as np
import pandas as pd
from sklearn.cross_validation import train_test_split

from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import SGDClassifier
from sklearn.metrics import classification_report as c_report

column_names = ['Sample code number', 'Clump Thickness', 'Uniformity of Cell Size', 'Uniformity of Cell Shape',
                'Marginal Adhesion', 'Single Epithelial Cell Size', 'Bare Nuclei', 'Bland Chromatin', 'Normal Nucleoli',
                'Mitoses', 'Class']

# 本地数据和网络数据去除缺失值后数量不同？？？,读取时少写了一个参数造成的
data = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/BreastCancer/breast-cancer-wisconsin.data',
                   names=column_names)
# data = pd.read_csv(
#     'https://archive.ics.uci.edu/ml/machine-learning-databases/breast-cancer-wisconsin/breast-cancer-wisconsin.data',
#     names=column_names)

data = data.replace(to_replace='?', value=np.nan)

data = data.dropna(how='any')

print data.shape

# 随机采样25%的数据作为测试集，剩余75%作为训练集
# X_train是训练集特征，X_test是测试集特征，y_train是训练集标记,y_test是测试标记
X_train, X_test, y_train, y_test = train_test_split(data[column_names[1:10]], data[column_names[10]], test_size=0.25,
                                                    random_state=33)
print y_train.value_counts()
print y_test.value_counts()

# 数据标准化，使每个维度的特征数据方差为1，均值为0，预测结果就不会被某些维度过大的特征而主导
ss = StandardScaler()
X_train = ss.fit_transform(X_train)
X_test = ss.transform(X_test)

# 逻辑回归预测
lr = LogisticRegression()
lr.fit(X_train, y_train)
lr_y_predict = lr.predict(X_test)

print '逻辑回归分类器的准确率：', lr.score(X_test, y_test)
print c_report(y_test, lr_y_predict, target_names=['Benign', 'Malignant'])

# 随机梯度下降预测
sgdc = SGDClassifier()
sgdc.fit(X_train, y_train)
sgdc_y_predict = sgdc.predict(X_test)

print '随机梯度下降分类的准确率：', sgdc.score(X_test, y_test)
print c_report(y_test, sgdc_y_predict, target_names=['Benign', 'Malignant'])
