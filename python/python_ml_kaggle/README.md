# Python机器学习及实践 开始Kaggle比赛
练习

## 常用方法
fit()：训练算法，设置内部参数。接收训练集和类别标记两个参数。  
predict()：预测测试集类别标记，参数为测试集。

fit()：训练算法，设置内部参数。  
transform()：数据转换。  
fit_transform()：合并fit和transform两个方法。

## 数据预处理  
主要在sklearn.preprcessing包下。  

规范化：  
- MinMaxScaler :最大最小值规范化
- Normalizer :使每条数据各特征值的和为1
- StandardScaler :为使各特征的均值为0，方差为1
- Binarizer :为将数值型特征的二值化  

编码：  
- LabelEncoder :把字符串类型的数据转化为整型
- OneHotEncoder :特征用一个二进制数字来表示  


