# _*_ coding:utf-8 _*_

from sklearn.datasets import load_iris
from sklearn.cross_validation import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import classification_report
from sklearn.neighbors import KNeighborsClassifier

iris = load_iris()
print iris.data.shape
# print iris.DESCR

X_train, X_test, y_train, y_test = train_test_split(iris.data, iris.target, test_size=0.25, random_state=33)
print len(y_train)
print len(y_test)

ss = StandardScaler()
X_train = ss.fit_transform(X_train)
X_test = ss.transform(X_test)

knc = KNeighborsClassifier()
knc.fit(X_train, y_train)
y_predict = knc.predict(X_test)

print 'KNN分类的准确度是：', knc.score(X_test, y_test)
print classification_report(y_test, y_predict, target_names=iris.target_names)
