# _*_ coding:utf-8 _*_

import numpy as np
import pandas as pd
import tensorflow as tf
import matplotlib.pyplot as plt

# 读取训练集和测试集
train = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/BreastCancer/breast-cancer-train.csv')
test = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/BreastCancer/breast-cancer-test.csv')

# 分离特征与分类标记
X_train = np.float32(train[['Clump Thickness', 'Cell Size']].T)
y_train = np.float32(train['Type'].T)
X_test = np.float32(test[['Clump Thickness', 'Cell Size']].T)
y_test = np.float32(test['Type'].T)

# 显式创建线性回归函数
b = tf.Variable(tf.zeros([1]))
W = tf.Variable(tf.random_uniform([1, 2], -1.0, 1.0))
y = tf.matmul(W, X_train) + b

# 取得均方误差
loss = tf.reduce_mean(tf.square(y - y_train))

# 使用梯度下降法估计W, b，设置迭代步长为0.01
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)

# 初始化变量
init = tf.initialize_all_variables()

# 启动图 (graph)
sess = tf.Session()

sess.run(init)

# 迭代1000次，训练参数
for step in xrange(0, 1000):
    sess.run(train)
    if step % 200 == 0:
        print step, sess.run(W), sess.run(b)

test_negative = test.loc[test['Type'] == 0][['Clump Thickness', 'Cell Size']]
test_positive = test.loc[test['Type'] == 1][['Clump Thickness', 'Cell Size']]

plt.scatter(test_negative['Clump Thickness'], test_negative['Cell Size'], marker='o', s=200, c='red')
plt.scatter(test_positive['Clump Thickness'], test_positive['Cell Size'], marker='x', s=150, c='black')

plt.xlabel('Clump Thickness')
plt.ylabel('Cell Size')

lx = np.arange(0, 12)

# 以0.5作为分界面
ly = (0.5 - sess.run(b) - lx * sess.run(W)[0][0]) / sess.run(W)[0][1]

plt.plot(lx, ly, color='green')
plt.show()


# sess = tf.Session()
#
# # 简单常量计算
# greeting = tf.constant('Hello, B**ches')
# result1 = sess.run(greeting)
# print result1
#
# # 简单线性函数计算
# m1 = tf.constant([[3., 3.]])
# m2 = tf.constant([[2.], [2.]])
# # 相乘
# product = tf.matmul(m1, m2)
# # 求和
# linear = tf.add(product, tf.constant(2.0))
# result2 = sess.run(linear)
# print result2
#
# sess.close()
