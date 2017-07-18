# Mobike算法挑战赛

## target
predict each bike's top 3 possible locations in the testing set

## data
#### train 3,214,096
1. orderid  
2. userid
3. bikeid
4. biketype
5. starttime
6. geohashed_start_loc
7. geohashed_end_loc

#### test 2,009,996
1. orderid  
2. userid
3. bikeid
4. biketype
5. starttime
6. geohashed_start_loc

#### submit
1. orderid
2. end_location1
3. end_location2
4. end_location3


## misc

#### mysql

 **testing set**
  
- fields
"orderid","userid","bikeid","biketype","starttime","geohashed_start_loc","startLng","startLat"  


```
create database if not exists mobike_tracks default charset utf8 collate utf8_general_ci;
```

```
create table mobike_tracks_test(orderid int primary key, userid int , bikeid int, biketype tinyint, starttime datetime, geohashed_start_loc varchar(36), startLng double, startLat double);
```

TRUNCATE [TABLE] tbl_name  
