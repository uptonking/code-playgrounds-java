# _*_ coding:utf-8 _*_

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.cluster import KMeans
from sklearn import metrics
from sklearn.metrics import silhouette_score

digits_train = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/optdigits/optdigits.tra', header=None)
digits_test = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/optdigits/optdigits.tes', header=None)

X_train = digits_train[np.arange(64)]
y_train = digits_train[64]
X_test = digits_test[np.arange(64)]
y_test = digits_test[64]

kmeans10 = KMeans(n_clusters=10)
kmeans10.fit(X_train)
kmeans10_y_predict = kmeans10.predict(X_test)

# 训练数据带有类别标记时，使用ARI指数评估聚类
print 'KMeans10聚类的ARI指数是：', metrics.adjusted_rand_score(y_test, kmeans10_y_predict)

kmeans6 = KMeans(n_clusters=6)
kmeans6.fit(X_train)
kmeans6_y_predict = kmeans6.predict(X_test)

# 训练数据带有类别标记时，使用ARI指数评估聚类
print 'KMeans6聚类的ARI指数是：', metrics.adjusted_rand_score(y_test, kmeans6_y_predict)


kmeans14 = KMeans(n_clusters=14)
kmeans14.fit(X_train)
kmeans14_y_predict = kmeans14.predict(X_test)

# 训练数据带有类别标记时，使用ARI指数评估聚类
print 'KMeans14聚类的ARI指数是：', metrics.adjusted_rand_score(y_test, kmeans14_y_predict)
