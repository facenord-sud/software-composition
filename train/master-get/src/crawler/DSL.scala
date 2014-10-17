package crawler

object DSL {
  private var request:Request = null

  def host(_host:String):Request = {
    request =  new Request(_host)
    return request
  }

  def host():Request = return request

  def get(file:String) = request get file
}