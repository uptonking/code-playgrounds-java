# _*_ coding:utf-8 _*_

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.decomposition import PCA
from sklearn.svm import LinearSVC
from sklearn.metrics import classification_report

digits_train = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/optdigits/optdigits.tra', header=None)
digits_test = pd.read_csv('/root/Documents/play/_src/python_ml_kaggle/datasets/optdigits/optdigits.tes', header=None)

X_train = digits_train[np.arange(64)]
y_train = digits_train[64]
X_test = digits_test[np.arange(64)]
y_test = digits_test[64]

estimator2 = PCA(n_components=2)
X_pca = estimator2.fit_transform(X_train)


def plot_pca_scatter():
    # 显示降维后数据的分布

    colors = ['black', 'blue', 'purple', 'yellow', 'white', 'red', 'lime', 'cyan', 'orange', 'gray']
    for i in xrange(len(colors)):
        px = X_pca[:, 0][y_train.as_matrix() == i]
        py = X_pca[:, 1][y_train.as_matrix() == i]
        plt.scatter(px, py, c=colors[i])

    plt.legend(np.arange(0, 10).astype(str))
    plt.xlabel('First Principal Component')
    plt.ylabel('Second Principal Component')
    plt.show()


# plot_pca_scatter()

svc = LinearSVC()
svc.fit(X_train, y_train)
svc_y_predict = svc.predict(X_test)

estimator20 = PCA(n_components=20)
X_pca = estimator20.fit_transform(X_train)

pca_X_train = estimator20.fit_transform(X_train)
pca_X_test = estimator20.transform(X_test)

pca_svc = LinearSVC()
pca_svc.fit(pca_X_train, y_train)
pca_y_predict = pca_svc.predict(pca_X_test)

print 'SVM模型的score是：', svc.score(X_test, y_test)
print classification_report(y_test, svc_y_predict, target_names=np.arange(10).astype(str))

print 'PCA-SVM模型的score是：', pca_svc.score(pca_X_test, y_test)
print classification_report(y_test, pca_y_predict, target_names=np.arange(10).astype(str))
