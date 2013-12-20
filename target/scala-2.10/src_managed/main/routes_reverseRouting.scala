// @SOURCE:D:/2013project/hsrhtl/conf/routes
// @HASH:9d1d2da74c402ee0c55912495ea2849efeb6800a
// @DATE:Wed Dec 18 11:08:16 CST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.order {

// @LINE:15
class ReverseSnapshotController {
    

// @LINE:15
def snapshot(orderNo:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hsrhtl/order/snapshot/" + implicitly[PathBindable[String]].unbind("orderNo", dynamicString(orderNo)))
}
                                                
    
}
                          

// @LINE:12
class ReverseCustomerInfoController {
    

// @LINE:12
def getCustomerInfo(personId:String, index:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hsrhtl/order/customerinfo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("personId", personId)), Some(implicitly[QueryStringBindable[String]].unbind("index", index)))))
}
                                                
    
}
                          

// @LINE:11
class ReverseMemberInfoController {
    

// @LINE:11
def getMemberInfo(personId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hsrhtl/order/memberinfo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("personId", personId)))))
}
                                                
    
}
                          

// @LINE:13
class ReverseAddFriendController {
    

// @LINE:13
def addFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "hsrhtl/order/addfriend")
}
                                                
    
}
                          

// @LINE:10
class ReverseOrderFormController {
    

// @LINE:10
def fillOrderForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "hsrhtl/orderform")
}
                                                
    
}
                          

// @LINE:14
class ReverseCreateOrderController {
    

// @LINE:14
def createOrder(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "hsrhtl/createorder")
}
                                                
    
}
                          
}
                  

// @LINE:25
// @LINE:23
// @LINE:18
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:7
class ReverseSearchListController {
    

// @LINE:7
def searchList(pageNo:Integer = 1, orderBy:String = "PRICE:ASC"): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hsrhtl/searchlist" + queryString(List(if(pageNo == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("pageNo", pageNo)), if(orderBy == "PRICE:ASC") None else Some(implicitly[QueryStringBindable[String]].unbind("orderBy", orderBy)))))
}
                                                
    
}
                          

// @LINE:25
// @LINE:23
class ReverseAjaxExampleController {
    

// @LINE:23
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ajax/index")
}
                                                

// @LINE:25
def getSomething(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ajax/getsomething")
}
                                                
    
}
                          

// @LINE:9
class ReverseLoginController {
    

// @LINE:9
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "hsrhtl/login")
}
                                                
    
}
                          

// @LINE:6
class ReverseIndexController {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hsrhtl/index")
}
                                                
    
}
                          

// @LINE:8
class ReverseRoomDescController {
    

// @LINE:8
def getRoomDesc(hotelNo:String, roomNo:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "hsrhtl/roomdesc" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hotelNo", hotelNo)), Some(implicitly[QueryStringBindable[String]].unbind("roomNo", roomNo)))))
}
                                                
    
}
                          
}
                  


// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.order.javascript {

// @LINE:15
class ReverseSnapshotController {
    

// @LINE:15
def snapshot : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.order.SnapshotController.snapshot",
   """
      function(orderNo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/order/snapshot/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("orderNo", encodeURIComponent(orderNo))})
      }
   """
)
                        
    
}
              

// @LINE:12
class ReverseCustomerInfoController {
    

// @LINE:12
def getCustomerInfo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.order.CustomerInfoController.getCustomerInfo",
   """
      function(personId,index) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/order/customerinfo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("personId", personId), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("index", index)])})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseMemberInfoController {
    

// @LINE:11
def getMemberInfo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.order.MemberInfoController.getMemberInfo",
   """
      function(personId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/order/memberinfo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("personId", personId)])})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseAddFriendController {
    

// @LINE:13
def addFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.order.AddFriendController.addFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/order/addfriend"})
      }
   """
)
                        
    
}
              

// @LINE:10
class ReverseOrderFormController {
    

// @LINE:10
def fillOrderForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.order.OrderFormController.fillOrderForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/orderform"})
      }
   """
)
                        
    
}
              

// @LINE:14
class ReverseCreateOrderController {
    

// @LINE:14
def createOrder : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.order.CreateOrderController.createOrder",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/createorder"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:25
// @LINE:23
// @LINE:18
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:7
class ReverseSearchListController {
    

// @LINE:7
def searchList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SearchListController.searchList",
   """
      function(pageNo,orderBy) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/searchlist" + _qS([(pageNo == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("pageNo", pageNo)), (orderBy == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("orderBy", orderBy))])})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:23
class ReverseAjaxExampleController {
    

// @LINE:23
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AjaxExampleController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/index"})
      }
   """
)
                        

// @LINE:25
def getSomething : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AjaxExampleController.getSomething",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/getsomething"})
      }
   """
)
                        
    
}
              

// @LINE:9
class ReverseLoginController {
    

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/login"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseIndexController {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/index"})
      }
   """
)
                        
    
}
              

// @LINE:8
class ReverseRoomDescController {
    

// @LINE:8
def getRoomDesc : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RoomDescController.getRoomDesc",
   """
      function(hotelNo,roomNo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hsrhtl/roomdesc" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hotelNo", hotelNo), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("roomNo", roomNo)])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.order.ref {


// @LINE:15
class ReverseSnapshotController {
    

// @LINE:15
def snapshot(orderNo:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.SnapshotController]).snapshot(orderNo), HandlerDef(this, "controllers.order.SnapshotController", "snapshot", Seq(classOf[String]), "GET", """""", _prefix + """hsrhtl/order/snapshot/$orderNo<[^/]+>""")
)
                      
    
}
                          

// @LINE:12
class ReverseCustomerInfoController {
    

// @LINE:12
def getCustomerInfo(personId:String, index:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.CustomerInfoController]).getCustomerInfo(personId, index), HandlerDef(this, "controllers.order.CustomerInfoController", "getCustomerInfo", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """hsrhtl/order/customerinfo""")
)
                      
    
}
                          

// @LINE:11
class ReverseMemberInfoController {
    

// @LINE:11
def getMemberInfo(personId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.MemberInfoController]).getMemberInfo(personId), HandlerDef(this, "controllers.order.MemberInfoController", "getMemberInfo", Seq(classOf[String]), "GET", """""", _prefix + """hsrhtl/order/memberinfo""")
)
                      
    
}
                          

// @LINE:13
class ReverseAddFriendController {
    

// @LINE:13
def addFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.AddFriendController]).addFriend(), HandlerDef(this, "controllers.order.AddFriendController", "addFriend", Seq(), "POST", """""", _prefix + """hsrhtl/order/addfriend""")
)
                      
    
}
                          

// @LINE:10
class ReverseOrderFormController {
    

// @LINE:10
def fillOrderForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.OrderFormController]).fillOrderForm(), HandlerDef(this, "controllers.order.OrderFormController", "fillOrderForm", Seq(), "POST", """""", _prefix + """hsrhtl/orderform""")
)
                      
    
}
                          

// @LINE:14
class ReverseCreateOrderController {
    

// @LINE:14
def createOrder(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.CreateOrderController]).createOrder(), HandlerDef(this, "controllers.order.CreateOrderController", "createOrder", Seq(), "POST", """""", _prefix + """hsrhtl/createorder""")
)
                      
    
}
                          
}
        

// @LINE:25
// @LINE:23
// @LINE:18
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:7
class ReverseSearchListController {
    

// @LINE:7
def searchList(pageNo:Integer, orderBy:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.SearchListController]).searchList(pageNo, orderBy), HandlerDef(this, "controllers.SearchListController", "searchList", Seq(classOf[Integer], classOf[String]), "GET", """""", _prefix + """hsrhtl/searchlist""")
)
                      
    
}
                          

// @LINE:25
// @LINE:23
class ReverseAjaxExampleController {
    

// @LINE:23
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AjaxExampleController]).index(), HandlerDef(this, "controllers.AjaxExampleController", "index", Seq(), "GET", """""", _prefix + """ajax/index""")
)
                      

// @LINE:25
def getSomething(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AjaxExampleController]).getSomething(), HandlerDef(this, "controllers.AjaxExampleController", "getSomething", Seq(), "POST", """""", _prefix + """ajax/getsomething""")
)
                      
    
}
                          

// @LINE:9
class ReverseLoginController {
    

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LoginController]).login(), HandlerDef(this, "controllers.LoginController", "login", Seq(), "POST", """""", _prefix + """hsrhtl/login""")
)
                      
    
}
                          

// @LINE:6
class ReverseIndexController {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.IndexController]).index(), HandlerDef(this, "controllers.IndexController", "index", Seq(), "GET", """ Home page""", _prefix + """hsrhtl/index""")
)
                      
    
}
                          

// @LINE:8
class ReverseRoomDescController {
    

// @LINE:8
def getRoomDesc(hotelNo:String, roomNo:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RoomDescController]).getRoomDesc(hotelNo, roomNo), HandlerDef(this, "controllers.RoomDescController", "getRoomDesc", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """hsrhtl/roomdesc""")
)
                      
    
}
                          
}
        
    