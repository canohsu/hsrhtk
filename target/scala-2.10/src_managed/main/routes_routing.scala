// @SOURCE:D:/2013project/hsrhtl/conf/routes
// @HASH:9d1d2da74c402ee0c55912495ea2849efeb6800a
// @DATE:Wed Dec 18 11:08:16 CST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_IndexController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/index"))))
        

// @LINE:7
private[this] lazy val controllers_SearchListController_searchList1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/searchlist"))))
        

// @LINE:8
private[this] lazy val controllers_RoomDescController_getRoomDesc2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/roomdesc"))))
        

// @LINE:9
private[this] lazy val controllers_LoginController_login3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/login"))))
        

// @LINE:10
private[this] lazy val controllers_order_OrderFormController_fillOrderForm4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/orderform"))))
        

// @LINE:11
private[this] lazy val controllers_order_MemberInfoController_getMemberInfo5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/order/memberinfo"))))
        

// @LINE:12
private[this] lazy val controllers_order_CustomerInfoController_getCustomerInfo6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/order/customerinfo"))))
        

// @LINE:13
private[this] lazy val controllers_order_AddFriendController_addFriend7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/order/addfriend"))))
        

// @LINE:14
private[this] lazy val controllers_order_CreateOrderController_createOrder8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/createorder"))))
        

// @LINE:15
private[this] lazy val controllers_order_SnapshotController_snapshot9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hsrhtl/order/snapshot/"),DynamicPart("orderNo", """[^/]+""",true))))
        

// @LINE:18
private[this] lazy val controllers_Assets_at10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:23
private[this] lazy val controllers_AjaxExampleController_index11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/index"))))
        

// @LINE:25
private[this] lazy val controllers_AjaxExampleController_getSomething12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/getsomething"))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/index""","""@controllers.IndexController@.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/searchlist""","""@controllers.SearchListController@.searchList(pageNo:Integer ?= 1, orderBy:String ?= "PRICE:ASC")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/roomdesc""","""@controllers.RoomDescController@.getRoomDesc(hotelNo:String, roomNo:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/login""","""@controllers.LoginController@.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/orderform""","""@controllers.order.OrderFormController@.fillOrderForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/order/memberinfo""","""@controllers.order.MemberInfoController@.getMemberInfo(personId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/order/customerinfo""","""@controllers.order.CustomerInfoController@.getCustomerInfo(personId:String, index:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/order/addfriend""","""@controllers.order.AddFriendController@.addFriend()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/createorder""","""@controllers.order.CreateOrderController@.createOrder()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hsrhtl/order/snapshot/$orderNo<[^/]+>""","""@controllers.order.SnapshotController@.snapshot(orderNo:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/index""","""@controllers.AjaxExampleController@.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/getsomething""","""@controllers.AjaxExampleController@.getSomething()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_IndexController_index0(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.IndexController]).index(), HandlerDef(this, "controllers.IndexController", "index", Nil,"GET", """ Home page""", Routes.prefix + """hsrhtl/index"""))
   }
}
        

// @LINE:7
case controllers_SearchListController_searchList1(params) => {
   call(params.fromQuery[Integer]("pageNo", Some(1)), params.fromQuery[String]("orderBy", Some("PRICE:ASC"))) { (pageNo, orderBy) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.SearchListController]).searchList(pageNo, orderBy), HandlerDef(this, "controllers.SearchListController", "searchList", Seq(classOf[Integer], classOf[String]),"GET", """""", Routes.prefix + """hsrhtl/searchlist"""))
   }
}
        

// @LINE:8
case controllers_RoomDescController_getRoomDesc2(params) => {
   call(params.fromQuery[String]("hotelNo", None), params.fromQuery[String]("roomNo", None)) { (hotelNo, roomNo) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RoomDescController]).getRoomDesc(hotelNo, roomNo), HandlerDef(this, "controllers.RoomDescController", "getRoomDesc", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """hsrhtl/roomdesc"""))
   }
}
        

// @LINE:9
case controllers_LoginController_login3(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LoginController]).login(), HandlerDef(this, "controllers.LoginController", "login", Nil,"POST", """""", Routes.prefix + """hsrhtl/login"""))
   }
}
        

// @LINE:10
case controllers_order_OrderFormController_fillOrderForm4(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.OrderFormController]).fillOrderForm(), HandlerDef(this, "controllers.order.OrderFormController", "fillOrderForm", Nil,"POST", """""", Routes.prefix + """hsrhtl/orderform"""))
   }
}
        

// @LINE:11
case controllers_order_MemberInfoController_getMemberInfo5(params) => {
   call(params.fromQuery[String]("personId", None)) { (personId) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.MemberInfoController]).getMemberInfo(personId), HandlerDef(this, "controllers.order.MemberInfoController", "getMemberInfo", Seq(classOf[String]),"GET", """""", Routes.prefix + """hsrhtl/order/memberinfo"""))
   }
}
        

// @LINE:12
case controllers_order_CustomerInfoController_getCustomerInfo6(params) => {
   call(params.fromQuery[String]("personId", None), params.fromQuery[String]("index", None)) { (personId, index) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.CustomerInfoController]).getCustomerInfo(personId, index), HandlerDef(this, "controllers.order.CustomerInfoController", "getCustomerInfo", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """hsrhtl/order/customerinfo"""))
   }
}
        

// @LINE:13
case controllers_order_AddFriendController_addFriend7(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.AddFriendController]).addFriend(), HandlerDef(this, "controllers.order.AddFriendController", "addFriend", Nil,"POST", """""", Routes.prefix + """hsrhtl/order/addfriend"""))
   }
}
        

// @LINE:14
case controllers_order_CreateOrderController_createOrder8(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.CreateOrderController]).createOrder(), HandlerDef(this, "controllers.order.CreateOrderController", "createOrder", Nil,"POST", """""", Routes.prefix + """hsrhtl/createorder"""))
   }
}
        

// @LINE:15
case controllers_order_SnapshotController_snapshot9(params) => {
   call(params.fromPath[String]("orderNo", None)) { (orderNo) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.order.SnapshotController]).snapshot(orderNo), HandlerDef(this, "controllers.order.SnapshotController", "snapshot", Seq(classOf[String]),"GET", """""", Routes.prefix + """hsrhtl/order/snapshot/$orderNo<[^/]+>"""))
   }
}
        

// @LINE:18
case controllers_Assets_at10(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:23
case controllers_AjaxExampleController_index11(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AjaxExampleController]).index(), HandlerDef(this, "controllers.AjaxExampleController", "index", Nil,"GET", """""", Routes.prefix + """ajax/index"""))
   }
}
        

// @LINE:25
case controllers_AjaxExampleController_getSomething12(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AjaxExampleController]).getSomething(), HandlerDef(this, "controllers.AjaxExampleController", "getSomething", Nil,"POST", """""", Routes.prefix + """ajax/getsomething"""))
   }
}
        
}

}
     