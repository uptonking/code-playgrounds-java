'use strict';

//用div初始化的地图对象
var map = L.map('bikemap').setView([39.95,116.35], 12);

//添加底图
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

//添加点图层，无数据，设置样式
var markers = L.geoJson(null, {
    pointToLayer: createClusterIcon
}).addTo(map);

//初始化worker，读取数据
var worker = new Worker('worker_training.js');
var ready = false;

//主线程接收worker的回传消息
//第一次加载数据完毕时，返回true，马上再将地图可见区域的范围发送到worker
//地图中心不再变化时，返回false
worker.onmessage = function (e) {

    if (e.data.ready) {
//    console.log('====1',ready);
        console.log('数据加载完毕');
        ready = true;
        update();
    } else {
//        console.log('====2',ready)
        markers.clearLayers();
        markers.addData(e.data);
    }
};

//将地图可见区域地理范围和缩放级别发送到worker
function update() {

    if (!ready) return;

    var bounds = map.getBounds();

    worker.postMessage({
        bbox: [bounds.getWest(), bounds.getSouth(), bounds.getEast(), bounds.getNorth()],
        zoom: map.getZoom()
    });
}

//监听地图可视区域中心的变化
map.on('moveend', update);

//输入点，输出特定样式的marker
function createClusterIcon(feature, latlng) {

    if (!feature.properties.cluster) return L.marker(latlng);

    var count = feature.properties.point_count;

    var size =
        count < 100 ? 'small' :
        count < 1000 ? 'medium' : 'large';

    var icon = L.divIcon({
        html: '<div><span>' + feature.properties.point_count_abbreviated + '</span></div>',
        className: 'marker-cluster marker-cluster-' + size,
        iconSize: L.point(40, 40)
    });

    return L.marker(latlng, {icon: icon});
}
