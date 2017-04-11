object CallRef {

  def main(args: Array[String]) {
    delayed(time());
  }

  def time() = {
    println("获取时间方法， 单位为纳秒")
    System.nanoTime
  }

  def delayed(t: => Long) = {
    println("在 delayed 方法内")
    println("参数t是： " + t)
    t
  }

  // 结果是
  // 在 delayed 方法内
  // 获取时间方法， 单位为纳秒
  // 参数t是： 17516942299967
  // 获取时间方法， 单位为纳秒

}
