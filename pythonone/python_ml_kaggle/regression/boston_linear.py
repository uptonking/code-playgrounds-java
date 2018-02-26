# _*_  coding:utf-8 _*_

import numpy as np
import pandas as pd

from sklearn.cross_validation import train_test_split
from sklearn.preprocessing import StandardScaler

from sklearn.datasets import load_boston

from sklearn.linear_model import LinearRegression, SGDRegressor
from sklearn.metrics import r2_score, mean_absolute_error, mean_squared_error

boston = load_boston()
print boston.data.shape

X = boston.data
y = boston.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=33)

ss_X = ss_y = StandardScaler()
X_train = ss_X.fit_transform(X_train)
X_test = ss_X.transform(X_test)
y_train = ss_y.fit_transform(y_train)
y_test = ss_y.transform(y_test)

# 线使用LinearRegression回归器
lr = LinearRegression()
lr.fit(X_train, y_train)
lr_y_predict = lr.predict(X_test)

print 'LinearRegression模型预测房价的'
print '  lr.score()：', lr.score(X_test, y_test)
print '  R-squared是：', r2_score(y_test, lr_y_predict)
print '  均方差是：', mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(lr_y_predict))
print '  平均绝对误差是：', mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(lr_y_predict))

# 使用SGDRegressor回归器
sgdr = SGDRegressor()
sgdr.fit(X_train, y_train)
sgdr_y_predict = sgdr.predict(X_test)

print 'SGDRegressor模型预测房价的'
print '  sgdr.score()：', sgdr.score(X_test, y_test)
print '  R-squared是：', r2_score(y_test, sgdr_y_predict)
print '  均方差是：', mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(sgdr_y_predict))
print '  平均绝对误差是：', mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(sgdr_y_predict))
