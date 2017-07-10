# _*_ coding:utf-8 _*_

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.linear_model import LogisticRegression

# 读取训练集和测试集
df_train = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/BreastCancer/breast-cancer-train.csv')
df_test = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/BreastCancer/breast-cancer-test.csv')

# 构建测试集分类标签样本
df_test_negative = df_test.loc[df_test['Type'] == 0][['Clump Thickness', 'Cell Size']]
df_test_positive = df_test.loc[df_test['Type'] == 1][['Clump Thickness', 'Cell Size']]

# 观察测试集整体分布情况
plt.scatter(df_test_negative['Clump Thickness'], df_test_negative['Cell Size'], marker='o', s=200, c='red')
plt.scatter(df_test_positive['Clump Thickness'], df_test_positive['Cell Size'], marker='x', s=150, c='black')

plt.xlabel('Clump Thickness')
plt.ylabel('Cell Size')

# plt.show()

# 生成随机采样直线ax+by+c=0的参数
# c
intercept = np.random.random([1])
# a,b
coef = np.random.random([2])
lx = np.arange(0, 12)
# y=(-c-ax)/b
ly = (-intercept - lx * coef[0]) / coef[1]
# plt.plot(lx, ly, c='yellow')

# plt.show()

lr = LogisticRegression()

# 训练10条样本
lr.fit(df_train[['Clump Thickness', 'Cell Size']][:80], df_train['Type'][:80])
print 'Test Accuracy of 10 training samples: ', lr.score(df_test[['Clump Thickness', 'Cell Size']], df_test['Type'])
intercept = lr.intercept_
coef = lr.coef_[0, :]
ly = (-intercept - coef[0] * lx) / coef[1]
plt.plot(lx, ly, c='grey')
# plt.show()

# 训练所有数据
lr.fit(df_train[['Clump Thickness', 'Cell Size']], df_train['Type'])
print 'Test Accuracy of all training samples: ', lr.score(df_test[['Clump Thickness', 'Cell Size']], df_test['Type'])
intercept = lr.intercept_
coef = lr.coef_[0, :]
ly = (-intercept - coef[0] * lx) / coef[1]
plt.plot(lx, ly, c='green')
plt.show()
