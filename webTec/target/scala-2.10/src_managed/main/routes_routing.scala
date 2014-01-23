// @SOURCE:C:/Users/uwe/git/webTec16/webTec/conf/routes
// @HASH:0483305f8c8e1f0cc085493214265723b14cbac9
// @DATE:Thu Jan 16 22:47:31 CET 2014


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
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_about1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("about"))))
        

// @LINE:8
private[this] lazy val controllers_Angebote_myOffers2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("meineAngebote"))))
        

// @LINE:9
private[this] lazy val controllers_Angebote_createOffer3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotErstellen"))))
        

// @LINE:10
private[this] lazy val controllers_Angebote_createRoute4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotErstellen"))))
        

// @LINE:11
private[this] lazy val controllers_Angebote_displayOffer5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotAnzeigen/"),DynamicPart("Id", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_Requests_createRequest6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotAnzeigen/"),DynamicPart("Id", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_Angebote_changeOfferForm7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotAendern/"),DynamicPart("Id", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Angebote_changeOffer8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotAendern/"),DynamicPart("Id", """[^/]+""",true))))
        

// @LINE:16
private[this] lazy val controllers_Angebote_destroyOffer9 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angebotErstellen/"),DynamicPart("Id", """[^/]+""",true))))
        

// @LINE:17
private[this] lazy val controllers_Login_showLoginForm10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:19
private[this] lazy val controllers_Login_login11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:20
private[this] lazy val controllers_AngeboteSuchen_angeboteSuchen12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("angeboteSuchen"))))
        

// @LINE:22
private[this] lazy val controllers_Application_logout13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:23
private[this] lazy val controllers_Registration_createUser14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:24
private[this] lazy val controllers_Registration_showRegistrationForm15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:25
private[this] lazy val controllers_Requests_displayRequests16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("meineAnfragen"))))
        

// @LINE:26
private[this] lazy val controllers_Requests_processRequest17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("meineAnfragen/"),DynamicPart("Id", """[^/]+""",true),StaticPart("/"),DynamicPart("what", """[^/]+""",true))))
        

// @LINE:27
private[this] lazy val controllers_Application_javascriptRoutes18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
        

// @LINE:29
private[this] lazy val controllers_Assets_at19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """about""","""controllers.Application.about()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """meineAngebote""","""controllers.Angebote.myOffers()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotErstellen""","""controllers.Angebote.createOffer()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotErstellen""","""controllers.Angebote.createRoute()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotAnzeigen/$Id<[^/]+>""","""controllers.Angebote.displayOffer(Id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotAnzeigen/$Id<[^/]+>""","""controllers.Requests.createRequest(Id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotAendern/$Id<[^/]+>""","""controllers.Angebote.changeOfferForm(Id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotAendern/$Id<[^/]+>""","""controllers.Angebote.changeOffer(Id:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angebotErstellen/$Id<[^/]+>""","""controllers.Angebote.destroyOffer(Id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Login.showLoginForm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Login.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """angeboteSuchen""","""controllers.AngeboteSuchen.angeboteSuchen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.Registration.createUser()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.Registration.showRegistrationForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """meineAnfragen""","""controllers.Requests.displayRequests()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """meineAnfragen/$Id<[^/]+>/$what<[^/]+>""","""controllers.Requests.processRequest(Id:String, what:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.Application.javascriptRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_about1(params) => {
   call { 
        invokeHandler(controllers.Application.about(), HandlerDef(this, "controllers.Application", "about", Nil,"GET", """""", Routes.prefix + """about"""))
   }
}
        

// @LINE:8
case controllers_Angebote_myOffers2(params) => {
   call { 
        invokeHandler(controllers.Angebote.myOffers(), HandlerDef(this, "controllers.Angebote", "myOffers", Nil,"GET", """""", Routes.prefix + """meineAngebote"""))
   }
}
        

// @LINE:9
case controllers_Angebote_createOffer3(params) => {
   call { 
        invokeHandler(controllers.Angebote.createOffer(), HandlerDef(this, "controllers.Angebote", "createOffer", Nil,"GET", """""", Routes.prefix + """angebotErstellen"""))
   }
}
        

// @LINE:10
case controllers_Angebote_createRoute4(params) => {
   call { 
        invokeHandler(controllers.Angebote.createRoute(), HandlerDef(this, "controllers.Angebote", "createRoute", Nil,"POST", """""", Routes.prefix + """angebotErstellen"""))
   }
}
        

// @LINE:11
case controllers_Angebote_displayOffer5(params) => {
   call(params.fromPath[String]("Id", None)) { (Id) =>
        invokeHandler(controllers.Angebote.displayOffer(Id), HandlerDef(this, "controllers.Angebote", "displayOffer", Seq(classOf[String]),"GET", """""", Routes.prefix + """angebotAnzeigen/$Id<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_Requests_createRequest6(params) => {
   call(params.fromPath[String]("Id", None)) { (Id) =>
        invokeHandler(controllers.Requests.createRequest(Id), HandlerDef(this, "controllers.Requests", "createRequest", Seq(classOf[String]),"POST", """""", Routes.prefix + """angebotAnzeigen/$Id<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_Angebote_changeOfferForm7(params) => {
   call(params.fromPath[String]("Id", None)) { (Id) =>
        invokeHandler(controllers.Angebote.changeOfferForm(Id), HandlerDef(this, "controllers.Angebote", "changeOfferForm", Seq(classOf[String]),"GET", """""", Routes.prefix + """angebotAendern/$Id<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Angebote_changeOffer8(params) => {
   call(params.fromPath[String]("Id", None)) { (Id) =>
        invokeHandler(controllers.Angebote.changeOffer(Id), HandlerDef(this, "controllers.Angebote", "changeOffer", Seq(classOf[String]),"POST", """""", Routes.prefix + """angebotAendern/$Id<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_Angebote_destroyOffer9(params) => {
   call(params.fromPath[String]("Id", None)) { (Id) =>
        invokeHandler(controllers.Angebote.destroyOffer(Id), HandlerDef(this, "controllers.Angebote", "destroyOffer", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """angebotErstellen/$Id<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_Login_showLoginForm10(params) => {
   call { 
        invokeHandler(controllers.Login.showLoginForm(), HandlerDef(this, "controllers.Login", "showLoginForm", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:19
case controllers_Login_login11(params) => {
   call { 
        invokeHandler(controllers.Login.login(), HandlerDef(this, "controllers.Login", "login", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:20
case controllers_AngeboteSuchen_angeboteSuchen12(params) => {
   call { 
        invokeHandler(controllers.AngeboteSuchen.angeboteSuchen(), HandlerDef(this, "controllers.AngeboteSuchen", "angeboteSuchen", Nil,"POST", """""", Routes.prefix + """angeboteSuchen"""))
   }
}
        

// @LINE:22
case controllers_Application_logout13(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:23
case controllers_Registration_createUser14(params) => {
   call { 
        invokeHandler(controllers.Registration.createUser(), HandlerDef(this, "controllers.Registration", "createUser", Nil,"POST", """""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:24
case controllers_Registration_showRegistrationForm15(params) => {
   call { 
        invokeHandler(controllers.Registration.showRegistrationForm(), HandlerDef(this, "controllers.Registration", "showRegistrationForm", Nil,"GET", """""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:25
case controllers_Requests_displayRequests16(params) => {
   call { 
        invokeHandler(controllers.Requests.displayRequests(), HandlerDef(this, "controllers.Requests", "displayRequests", Nil,"GET", """""", Routes.prefix + """meineAnfragen"""))
   }
}
        

// @LINE:26
case controllers_Requests_processRequest17(params) => {
   call(params.fromPath[String]("Id", None), params.fromPath[String]("what", None)) { (Id, what) =>
        invokeHandler(controllers.Requests.processRequest(Id, what), HandlerDef(this, "controllers.Requests", "processRequest", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """meineAnfragen/$Id<[^/]+>/$what<[^/]+>"""))
   }
}
        

// @LINE:27
case controllers_Application_javascriptRoutes18(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """""", Routes.prefix + """assets/javascripts/routes"""))
   }
}
        

// @LINE:29
case controllers_Assets_at19(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     