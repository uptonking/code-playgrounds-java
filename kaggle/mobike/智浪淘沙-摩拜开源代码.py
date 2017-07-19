# -*- coding: utf-8 -*-
"""
Created on Thu Jul  6 13:41:45 2017

@author: ZHILANGTAOSHA
"""


import pandas as pd
import geohash
from math import radians, cos, sin, asin, sqrt  
#import itertools
import numpy as np
import math  
import xgboost as xgb

def cal_dis(latitude1, longitude1,latitude2, longitude2):  
    latitude1 = (math.pi/180.0)*latitude1  
    latitude2 = (math.pi/180.0)*latitude2  
    longitude1 = (math.pi/180.0)*longitude1  
    longitude2= (math.pi/180.0)*longitude2  
    #因此AB两点的球面距离为:{arccos[sina*sinx+cosb*cosx*cos(b-y)]}*R  (a,b,x,y)  
    #地球半径  
    R = 6378.1  
    temp=math.sin(latitude1)*math.sin(latitude2)+ math.cos(latitude1)*math.cos(latitude2)*math.cos(longitude2-longitude1)  
    if repr(temp)>1.0:  
         temp = 1.0  
    d = math.acos(temp)*R  
    return d;    

def draw(data, n_sep=300, mult=1, shape=None):
    '''
    :param data: dataframe格式，包含经纬度信息
    :param n_sep: 像素点个数 n_sep * n_sep
    :param mult: 颜色深浅
    :param shape: 显示的区域大小，None时显示全图
    '''
    from PIL import Image
    if shape is not None:
        lon_std = data['start_loc_lon'].std()
        lon_ave = data['start_loc_lon'].mean()
        lat_std = data['start_loc_lat'].std()
        lat_ave = data['start_loc_lat'].mean()
        temp = data[(data['start_loc_lon'] > (lon_ave - shape * lon_std)) & (data['start_loc_lon'] < (lon_ave + shape * lon_std))]
        temp = temp[(temp['start_loc_lat'] > (lat_ave - shape * lat_std)) & (temp['start_loc_lat'] < (lat_ave + shape * lat_std))]
    sep = (temp['start_loc_lon'].max()-temp['start_loc_lon'].min())/n_sep
    temp['start_loc_lon'] = temp['start_loc_lon'] // sep
    temp['start_loc_lat'] = temp['start_loc_lat'] // sep
    matrix = temp.groupby(['start_loc_lon','start_loc_lat'])['userid'].count().unstack().fillna(0)

    im = Image.fromarray(matrix.values*mult)
    im = im.convert('RGB')
    im.save(r'..\a.jpg', format='jpeg')
    
def haversine(lon1, lat1, lon2, lat2): # 经度1，纬度1，经度2，纬度2 （十进制度数）  
    """ 
    Calculate the great circle distance between two points  
    on the earth (specified in decimal degrees) 
    """  
    # 将十进制度数转化为弧度  
    lon1, lat1, lon2, lat2 = map(radians, [lon1, lat1, lon2, lat2])  
  
    # haversine公式  
    dlon = lon2 - lon1   
    dlat = lat2 - lat1   
    a = sin(dlat/2)**2 + cos(lat1) * cos(lat2) * sin(dlon/2)**2  
    c = 2 * asin(sqrt(a))   
    r = 6371 # 地球平均半径，单位为公里  
    return c * r * 1000  


def distance_haver(lon1, lat1, lon2, lat2):
    dx = np.absolute(lon1 - lon2)  # 经度差
    dy = np.absolute(lat1 - lat2)  # 维度差
    b = (lat1 + lat2) / 2.0
    Lx = (dx / 57.2958) * 6371004.0 * np.cos(b / 57.2958)
    Ly = 6371004.0 * (dy / 57.2958)
    L = (Lx**2 + Ly**2) ** 0.5
    return L

def train_tztq(train):
    zh = train[['geohashed_start_loc','geohashed_end_loc']]
    zh.loc[:,'pl'] = 1
    zh = zh.groupby(['geohashed_start_loc','geohashed_end_loc'])['pl'].count().reset_index()
    zh['max_dd'] = zh[['geohashed_start_loc','geohashed_end_loc']].max(axis=1)
    zh['min_dd'] = zh[['geohashed_start_loc','geohashed_end_loc']].min(axis=1)
    
    #统计相同两个点的关联个数
    zh = zh.groupby(['max_dd','min_dd'])['pl'].agg({'zz':np.sum,'gs':np.size}).reset_index()
    print(zh.shape)
    
    #换算为经纬度
    zh.loc[:,'start_jw'] = zh.max_dd.map(geohash.decode)
    zh.loc[:,'start_j'] = zh.start_jw.map(lambda x:x[0])
    zh.loc[:,'start_w'] = zh.start_jw.map(lambda x:x[1])
    zh.loc[:,'end_jw'] = zh.min_dd.map(geohash.decode)
    zh.loc[:,'end_j'] = zh.end_jw.map(lambda x:x[0])
    zh.loc[:,'end_w'] = zh.end_jw.map(lambda x:x[1])
    del zh['start_jw'],zh['end_jw']
    
    #计算经纬度的具体距离
    zh.loc[:,'juli'] = zh.apply(lambda x:distance_haver(x['start_j'],x['start_w'],x['end_j'],x['end_w']),axis=1)
    
    #建立最后的地点画像
    
    #计算大的维度的地点对应个数
    max_dd_tz = zh.groupby('max_dd').agg({'gs':np.size})
    #计算训练集中地点出现的总次数
    max_dd_tz['zz_gs'] = zh.groupby('max_dd')['zz'].agg({'zz_gs':np.sum})
    
    #计算
    #地点所至最大距离
    max_dd_tz['juli_max'] = zh.groupby('max_dd')['juli'].max()
    #地点所至最小距离
    max_dd_tz['juli_min'] = zh.groupby('max_dd')['juli'].min()
    #地点所至中值
    max_dd_tz['juli_median'] = zh.groupby('max_dd')['juli'].median()
    
    
    #计算大的维度的地点对应个数
    min_dd_tz = zh.groupby('min_dd').agg({'gs':np.size})
    #计算训练集中地点出现的总次数
    min_dd_tz['zz_gs'] = zh.groupby('min_dd')['zz'].agg({'zz_gs':np.sum})
    
    #计算
    #地点所至最大距离
    min_dd_tz['juli_max'] = zh.groupby('min_dd')['juli'].max()
    #地点所至最小距离
    min_dd_tz['juli_min'] = zh.groupby('min_dd')['juli'].min()
    #地点所至中值
    min_dd_tz['juli_median'] = zh.groupby('min_dd')['juli'].median()
    
    
    #拼接所有地点
    
    dd_tz = pd.concat([max_dd_tz,min_dd_tz])
    return dd_tz

def shijian_chuli(train):
    hour_sx = {0:1,1:1,2:1,3:1,4:1,5:1,6:2,7:4,8:4,9:4,10:2,11:2,12:5,13:5,14:2,15:3,16:3,17:6,18:6,19:6,20:3,21:3,22:1,23:1}
    week_sx = {0:1,1:1,2:1,3:1,4:1,5:2,6:2}
    train.loc[:,'starttime'] = pd.to_datetime(train.starttime)
    train['weekday_time'] = train.starttime.dt.weekday
    train['hour_time'] = train.starttime.dt.hour
    train['hour_sx'] = train.hour_time.map(hour_sx)
    train['week_sx'] = train.weekday_time.map(week_sx)
    return(train)

def jsjl(zh):
    js = zh[~zh.tj_dd.isnull()].drop_duplicates()
    #换算为经纬度
    js.loc[:,'start_jw'] = js.iloc[:,0].map(geohash.decode)
    js.loc[:,'start_j'] = js.start_jw.map(lambda x:x[0])
    js.loc[:,'start_w'] = js.start_jw.map(lambda x:x[1])
    js.loc[:,'end_jw'] = js.iloc[:,1].map(geohash.decode)
    js.loc[:,'end_j'] = js.end_jw.map(lambda x:x[0])
    js.loc[:,'end_w'] = js.end_jw.map(lambda x:x[1])
    del js['start_jw'],js['end_jw']    
    #计算经纬度的具体距离
    js.loc[:,'juli'] = js.apply(lambda x:distance_haver(x['start_j'],x['start_w'],x['end_j'],x['end_w']),axis=1)
    return js  

    
train = pd.read_csv('../input/train.csv')
#test = pd.read_csv('../input/test.csv')
#example = pd.read_csv('../input/sample_submission.csv',header=None)

print(train.shape)


train1 = ['2017-05-14',
 '2017-05-15',
 '2017-05-16',
 '2017-05-12',
 '2017-05-13',
 '2017-05-10',
 '2017-05-11']

train2 = ['2017-05-18',
 '2017-05-19',
 '2017-05-23',
 '2017-05-24',
 '2017-05-20',
 '2017-05-22',
 '2017-05-21']



train2 = train[train.starttime.map(lambda x:x[:10]).isin(train2)]
train = train[train.starttime.map(lambda x:x[:10]).isin(train1)]

train2 = shijian_chuli(train2)
train = shijian_chuli(train)
#test = shijian_chuli(test)

pj1 = train[['geohashed_start_loc','geohashed_end_loc','hour_sx','week_sx']]
pj1 = pj1.rename(columns = {'geohashed_end_loc':'tj_dd'})
pj1 = pj1.drop_duplicates()
z1 = pd.merge(train2,pj1,on = ['geohashed_start_loc','hour_sx','week_sx'],how = 'left')
del z1['starttime']

z1_not_null = z1[z1.tj_dd.isnull()]
z1 = z1[~z1.tj_dd.isnull()]
zh = z1.loc[:,('geohashed_start_loc','tj_dd')]
js = jsjl(zh)
z1 = pd.merge(z1,js[['geohashed_start_loc','tj_dd','juli']],on = ['geohashed_start_loc','tj_dd'],how = 'left')

train_dd_tz = train_tztq(train)
train_dd_tz = train_dd_tz.reset_index()
train_dd_tz = train_dd_tz.rename(columns={'index':'geohashed_start_loc'})


wpj = train_dd_tz[train_dd_tz.zz_gs > 100]

z1_all_more = z1[z1.geohashed_start_loc.isin(wpj.geohashed_start_loc)]

z1 = z1[~z1.geohashed_start_loc.isin(wpj.geohashed_start_loc)]

z1 = pd.merge(z1,train_dd_tz,on = 'geohashed_start_loc')
train_dd_tz = train_dd_tz.rename(columns={'geohashed_start_loc':'tj_dd'})
z1 = pd.merge(z1,train_dd_tz,on = 'tj_dd')

z1['label'] = z1.geohashed_end_loc == z1.tj_dd
z1.label=z1.label.map(int)

featurelist = [i for i in z1.columns if i not in ['orderid', 'geohashed_start_loc', 'geohashed_end_loc','tj_dd','label']]

params = {
        'objective ':'binary:logistic',
        'eval_metric':'map',
        'max_depth':11,
        'min_child_weight':0.9,
        'max_delta_step':10,
        'eta':0.3
}

del z1['tj_dd']

from sklearn.cross_validation import train_test_split
x,y = train_test_split(z1,test_size = 0.3)


x = xgb.DMatrix(x[featurelist],label = x.label)
y = xgb.DMatrix(y[featurelist],label = y.label)


test = pd.read_csv('../input/test.csv')
test = shijian_chuli(test)

pj1 = train2[['geohashed_start_loc','geohashed_end_loc','hour_sx','week_sx']]
pj1 = pj1.rename(columns = {'geohashed_end_loc':'tj_dd'})
pj1 = pj1.drop_duplicates()
z2 = pd.merge(test,pj1,on = ['geohashed_start_loc','hour_sx','week_sx'],how = 'left')
del z2['starttime']


zh = z2.loc[:,('geohashed_start_loc','tj_dd')]
js = jsjl(zh)
z2 = pd.merge(z2,js[['geohashed_start_loc','tj_dd','juli']],on = ['geohashed_start_loc','tj_dd'],how = 'left')

train_dd_tz = train_tztq(train2)
train_dd_tz = train_dd_tz.reset_index()
train_dd_tz = train_dd_tz.rename(columns={'index':'geohashed_start_loc'})


z2 = pd.merge(z2,train_dd_tz,on = 'geohashed_start_loc')
train_dd_tz = train_dd_tz.rename(columns={'geohashed_start_loc':'tj_dd'})
z2 = pd.merge(z2,train_dd_tz,on = 'tj_dd')
del z2['geohashed_start_loc']
#z2 = xgb.DMatrix(z2[featurelist])

watchlist = [(x,'train'), (y,'eval')]
evals_result = {}
num_round = 1000
bst = xgb.train(params, x, num_round, watchlist, evals_result=evals_result,early_stopping_rounds=20,maximize=True)






#
#print(z1.shape)
#
##pj2 = train2[['geohashed_start_loc','geohashed_end_loc','hour_sx']]
##pj2 = pj2.rename(columns = {'geohashed_end_loc':'tj_dd'})
##pj2 = pj2.drop_duplicates()
##z2 = pd.merge(test,pj2,on = ['geohashed_start_loc','hour_sx'],how = 'left')
##print(z2.shape)
##del z2['starttime']
##zh = z2.loc[:,('geohashed_start_loc','tj_dd')]
##js = jsjl(zh)
##
##z2 = pd.merge(z2,js[['geohashed_start_loc','tj_dd','juli']],on = ['geohashed_start_loc','tj_dd'],how = 'left')
#
#
#
#
#train_dd_tz = train_tztq(train)
#train_dd_tz = train_dd_tz.reset_index()
#
#wpj = train_dd_tz[train_dd_tz.zz_gs > 100]
#
#train_dd_tz = train_dd_tz[train_dd_tz.zz_gs < 100]

#
##z1_null = z1[z1.tj_dd.isnull()]
##z1 = z1[~z1.tj_dd.isnull()]
##
##
##
###test_dd_tz = train_tztq(train2)
###test_dd_tz = test_dd_tz.reset_index()
###test_dd_tz = test_dd_tz.rename(columns={'index':'geohashed_start_loc'})
###z2 = pd.merge(z2,test_dd_tz,on = 'geohashed_start_loc')
###test_dd_tz = test_dd_tz.rename(columns={'geohashed_start_loc':'tj_dd'})
###z2 = pd.merge(z2,test_dd_tz,on = 'tj_dd')
##
##z1['label'] = z1.geohashed_end_loc == z1.tj_dd
##z1.label=z1.label.map(int)
##
##del js,zh,pj1,train_dd_tz,train1,train2,train
##
###del js,zh,pj1,pj2,test,train_dd_tz,test_dd_tz,train1,train2,train
##
##featurelist = [i for i in z1.columns if i not in ['orderid', 'geohashed_start_loc', 'geohashed_end_loc','tj_dd','label']]
##
##params = {
##        'objective ':'binary:logistic',
##        'eval_metric':'map',
##        'max_depth':7,
##        'min_child_weight':0.9,
##        'max_delta_step':10,
##        'eta':0.3
##}
##del z1['geohashed_start_loc']
##del z1['geohashed_end_loc']
##del z1['tj_dd']
#
##z1.to_csv('z1.csv',index=False)
#
#
##d_train = xgb.DMatrix(z1[featurelist],label = z1.label)
###d_test = xgb.DMatrix(z2[featurelist])
##watchlist = [(d_train,'eval'), (d_train,'train')]
##
##del z1
##evals_result = {}
##num_round = 100
##bst = xgb.train(params, d_train, num_round, watchlist, evals_result=evals_result)
#
#
##pj1 = train[['geohashed_start_loc','geohashed_end_loc']]
##z1 = pd.merge(train2,pj1,on = 'geohashed_start_loc',how = 'left')
##
##print(z1.shape)
##
##pj2 = train2[['geohashed_start_loc','geohashed_end_loc']]
##z2 = pd.merge(test,pj2,on = 'geohashed_start_loc',how = 'left')
##print(z2.shape)
#
##pj1 = train[['userid','geohashed_end_loc']]
##pj1 = pj1.drop_duplicates()
##z1 = pd.merge(train2,pj1,on = 'userid',how = 'left')
##print(z1.shape)
##pj2 = train2[['userid','geohashed_end_loc']]
##pj2 = pj2.drop_duplicates()
##z2 = pd.merge(test,pj2,on = 'userid',how = 'left')
##print(z2.shape)
##
##pj1 = train[['bikeid','geohashed_end_loc']]
##pj1 = pj1.drop_duplicates()
##z1 = pd.merge(train2,pj1,on = 'bikeid',how = 'left')
##print(z1.shape)
##pj2 = train2[['bikeid','geohashed_end_loc']]
##pj2 = pj2.drop_duplicates()
##z2 = pd.merge(test,pj2,on = 'bikeid',how = 'left')
##print(z2.shape)
#
#
#
##==============================================================================
## User-start-end
## User-end
## Start-end
##==============================================================================
#
#
#
#