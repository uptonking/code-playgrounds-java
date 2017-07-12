# _*_ coding:utf-8 _*_

from sklearn.datasets import fetch_20newsgroups
from sklearn.cross_validation import train_test_split
from sklearn.feature_extraction.text import CountVectorizer, TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import classification_report

news = fetch_20newsgroups(subset='all')
print len(news.data)
# print news.data[0]

X_train, X_test, y_train, y_test = train_test_split(news.data, news.target, test_size=0.25, random_state=33)
print len(y_train)
print len(y_test)

# 停用词过滤器
count_filter_vec = CountVectorizer(analyzer='word', stop_words='english')
tfidf_filter_vec = TfidfVectorizer(analyzer='word', stop_words='english')

X_count_filter_train = count_filter_vec.fit_transform(X_train)
X_count_filter_test = count_filter_vec.transform(X_test)

X_tfidf_filter_train = tfidf_filter_vec.fit_transform(X_train)
X_tfidf_filter_test = tfidf_filter_vec.transform(X_test)

# 默认CountVectorizer不去除停止词
vec = CountVectorizer()
# X_count_train = vec.fit_transform(X_train)
# X_count_test = vec.transform(X_test)

mnb_count = MultinomialNB()
mnb_count.fit(X_count_filter_train, y_train)

y_count_predict = mnb_count.predict(X_count_filter_test)

print '使用CountVectorizer()处理后的朴素贝叶斯分类的准确度是：', mnb_count.score(X_count_filter_test, y_test)
print classification_report(y_test, y_count_predict, target_names=news.target_names)

# 默认TfidfVectorizer不去除停止词
tfidf_vec = TfidfVectorizer()
# X_tfidf_train = tfidf_vec.fit_transform(X_train)
# X_tfidf_test = tfidf_vec.transform(X_test)

mnb_tfidf = MultinomialNB()
mnb_tfidf.fit(X_tfidf_filter_train, y_train)
y_tfidf_predict = mnb_tfidf.predict(X_tfidf_filter_test)

print '使用TfidfVectorizer()处理后的朴素贝叶斯分类的准确度是：', mnb_tfidf.score(X_tfidf_filter_test, y_test)
print classification_report(y_test, y_tfidf_predict, target_names=news.target_names)
