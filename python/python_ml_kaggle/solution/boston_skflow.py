# _*_ coding:utf-8 _*_

from sklearn import datasets, metrics, preprocessing, cross_validation
from sklearn.ensemble import RandomForestRegressor
import skflow

boston = datasets.load_boston()
X, y = boston.data, boston.target

X_train, X_test, y_train, y_test = cross_validation.train_test_split(X, y, test_size=0.25, random_state=33)

# 标准化
ss = preprocessing.StandardScaler()
X_train = ss.fit_transform(X_train)
X_test = ss.transform(X_test)

# 使用skflow的TensorFlowLinearRegressor回归器训练
tf_lr = skflow.TensorFlowLinearRegressor(steps=10000, learning_rate=0.01, batch_size=50)
tf_lr.fit(X_train, y_train)
tf_lr_y_predict = tf_lr.predict(X_test)

# 使用skflow的TensorFlowDNNRegressor回归器训练
tf_dnn_regressor = skflow.TensorFlowDNNRegressor(hidden_units=[100, 40],
                                                 steps=10000, learning_rate=0.01, batch_size=50)
tf_dnn_regressor.fit(X_train, y_train)
tf_dnn_regressor_y_predict = tf_dnn_regressor.predict(X_test)

# 使用skflow的RandomForestRegressor回归器训练
rfr = RandomForestRegressor()
rfr.fit(X_train, y_train)
rfr_y_predict = rfr.predict(X_test)

print 'Boston房价TensorFlowLinearRegressor预测的'
print '  R-squared是：', metrics.r2_score(tf_lr_y_predict, y_test)
print '  平均绝对误差是：', metrics.mean_absolute_error(tf_lr_y_predict, y_test)
print '  均方差是：', metrics.mean_squared_error(tf_lr_y_predict, y_test)

print 'Boston房价TensorFlowDNNRegressor预测的'
print '  R-squared是：', metrics.r2_score(tf_dnn_regressor_y_predict, y_test)
print '  平均绝对误差是：', metrics.mean_absolute_error(tf_dnn_regressor_y_predict, y_test)
print '  均方差是：', metrics.mean_squared_error(tf_dnn_regressor_y_predict, y_test)

print 'Boston房价RandomForestRegressor预测的'
print '  R-squared是：', metrics.r2_score(rfr_y_predict, y_test)
print '  平均绝对误差是：', metrics.mean_absolute_error(rfr_y_predict, y_test)
print '  均方差是：', metrics.mean_squared_error(rfr_y_predict, y_test)
