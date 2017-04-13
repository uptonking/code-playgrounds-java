package space.yaooxx.w3school;

object ScalaFunc12 {

  def main(args: Array[String]) {

    val funs = new Function1[Int, Int] {
      def apply(x: Int) = {
        println("第一步:" + x)
        x + 1
      }

    }

    val succ = (x: Int) => {
      println("第二步:" + x)
      x + 3
    }

    println(succ.andThen(funs).apply(5))
    /**
     * 第二步:5
     * 第一步:8
     */

    println(succ.compose(funs).apply(5))
    /**
     * 第一步:5
     * 第二步:6
     */

  }
}
