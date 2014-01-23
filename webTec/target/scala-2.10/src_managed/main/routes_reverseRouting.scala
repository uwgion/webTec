// @SOURCE:C:/Users/uwe/git/webTec/webTec/conf/routes
// @HASH:0483305f8c8e1f0cc085493214265723b14cbac9
// @DATE:Thu Jan 23 16:30:05 CET 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:29
class ReverseAssets {
    

// @LINE:29
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:12
class ReverseRequests {
    

// @LINE:12
def createRequest(Id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "angebotAnzeigen/" + implicitly[PathBindable[String]].unbind("Id", dynamicString(Id)))
}
                                                

// @LINE:26
def processRequest(Id:String, what:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "meineAnfragen/" + implicitly[PathBindable[String]].unbind("Id", dynamicString(Id)) + "/" + implicitly[PathBindable[String]].unbind("what", dynamicString(what)))
}
                                                

// @LINE:25
def displayRequests(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "meineAnfragen")
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
class ReverseRegistration {
    

// @LINE:24
def showRegistrationForm(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "registration")
}
                                                

// @LINE:23
def createUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registration")
}
                                                
    
}
                          

// @LINE:19
// @LINE:17
class ReverseLogin {
    

// @LINE:19
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:17
def showLoginForm(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseAngebote {
    

// @LINE:14
def changeOfferForm(Id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "angebotAendern/" + implicitly[PathBindable[String]].unbind("Id", dynamicString(Id)))
}
                                                

// @LINE:11
def displayOffer(Id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "angebotAnzeigen/" + implicitly[PathBindable[String]].unbind("Id", dynamicString(Id)))
}
                                                

// @LINE:15
def changeOffer(Id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "angebotAendern/" + implicitly[PathBindable[String]].unbind("Id", dynamicString(Id)))
}
                                                

// @LINE:9
def createOffer(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "angebotErstellen")
}
                                                

// @LINE:16
def destroyOffer(Id:String): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "angebotErstellen/" + implicitly[PathBindable[String]].unbind("Id", dynamicString(Id)))
}
                                                

// @LINE:10
def createRoute(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "angebotErstellen")
}
                                                

// @LINE:8
def myOffers(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "meineAngebote")
}
                                                
    
}
                          

// @LINE:27
// @LINE:22
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def about(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "about")
}
                                                

// @LINE:22
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:27
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/routes")
}
                                                
    
}
                          

// @LINE:20
class ReverseAngeboteSuchen {
    

// @LINE:20
def angeboteSuchen(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "angeboteSuchen")
}
                                                
    
}
                          
}
                  


// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:29
class ReverseAssets {
    

// @LINE:29
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:25
// @LINE:12
class ReverseRequests {
    

// @LINE:12
def createRequest : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Requests.createRequest",
   """
      function(Id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotAnzeigen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Id", encodeURIComponent(Id))})
      }
   """
)
                        

// @LINE:26
def processRequest : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Requests.processRequest",
   """
      function(Id,what) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "meineAnfragen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Id", encodeURIComponent(Id)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("what", encodeURIComponent(what))})
      }
   """
)
                        

// @LINE:25
def displayRequests : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Requests.displayRequests",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "meineAnfragen"})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
class ReverseRegistration {
    

// @LINE:24
def showRegistrationForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.showRegistrationForm",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        

// @LINE:23
def createUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.createUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        
    
}
              

// @LINE:19
// @LINE:17
class ReverseLogin {
    

// @LINE:19
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:17
def showLoginForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.showLoginForm",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseAngebote {
    

// @LINE:14
def changeOfferForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.changeOfferForm",
   """
      function(Id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotAendern/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Id", encodeURIComponent(Id))})
      }
   """
)
                        

// @LINE:11
def displayOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.displayOffer",
   """
      function(Id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotAnzeigen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Id", encodeURIComponent(Id))})
      }
   """
)
                        

// @LINE:15
def changeOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.changeOffer",
   """
      function(Id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotAendern/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Id", encodeURIComponent(Id))})
      }
   """
)
                        

// @LINE:9
def createOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.createOffer",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotErstellen"})
      }
   """
)
                        

// @LINE:16
def destroyOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.destroyOffer",
   """
      function(Id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotErstellen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Id", encodeURIComponent(Id))})
      }
   """
)
                        

// @LINE:10
def createRoute : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.createRoute",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "angebotErstellen"})
      }
   """
)
                        

// @LINE:8
def myOffers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Angebote.myOffers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "meineAngebote"})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:22
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def about : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.about",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "about"})
      }
   """
)
                        

// @LINE:22
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:27
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/routes"})
      }
   """
)
                        
    
}
              

// @LINE:20
class ReverseAngeboteSuchen {
    

// @LINE:20
def angeboteSuchen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AngeboteSuchen.angeboteSuchen",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "angeboteSuchen"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:29
class ReverseAssets {
    

// @LINE:29
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:12
class ReverseRequests {
    

// @LINE:12
def createRequest(Id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Requests.createRequest(Id), HandlerDef(this, "controllers.Requests", "createRequest", Seq(classOf[String]), "POST", """""", _prefix + """angebotAnzeigen/$Id<[^/]+>""")
)
                      

// @LINE:26
def processRequest(Id:String, what:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Requests.processRequest(Id, what), HandlerDef(this, "controllers.Requests", "processRequest", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """meineAnfragen/$Id<[^/]+>/$what<[^/]+>""")
)
                      

// @LINE:25
def displayRequests(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Requests.displayRequests(), HandlerDef(this, "controllers.Requests", "displayRequests", Seq(), "GET", """""", _prefix + """meineAnfragen""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
class ReverseRegistration {
    

// @LINE:24
def showRegistrationForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.showRegistrationForm(), HandlerDef(this, "controllers.Registration", "showRegistrationForm", Seq(), "GET", """""", _prefix + """registration""")
)
                      

// @LINE:23
def createUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.createUser(), HandlerDef(this, "controllers.Registration", "createUser", Seq(), "POST", """""", _prefix + """registration""")
)
                      
    
}
                          

// @LINE:19
// @LINE:17
class ReverseLogin {
    

// @LINE:19
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.login(), HandlerDef(this, "controllers.Login", "login", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:17
def showLoginForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.showLoginForm(), HandlerDef(this, "controllers.Login", "showLoginForm", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseAngebote {
    

// @LINE:14
def changeOfferForm(Id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.changeOfferForm(Id), HandlerDef(this, "controllers.Angebote", "changeOfferForm", Seq(classOf[String]), "GET", """""", _prefix + """angebotAendern/$Id<[^/]+>""")
)
                      

// @LINE:11
def displayOffer(Id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.displayOffer(Id), HandlerDef(this, "controllers.Angebote", "displayOffer", Seq(classOf[String]), "GET", """""", _prefix + """angebotAnzeigen/$Id<[^/]+>""")
)
                      

// @LINE:15
def changeOffer(Id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.changeOffer(Id), HandlerDef(this, "controllers.Angebote", "changeOffer", Seq(classOf[String]), "POST", """""", _prefix + """angebotAendern/$Id<[^/]+>""")
)
                      

// @LINE:9
def createOffer(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.createOffer(), HandlerDef(this, "controllers.Angebote", "createOffer", Seq(), "GET", """""", _prefix + """angebotErstellen""")
)
                      

// @LINE:16
def destroyOffer(Id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.destroyOffer(Id), HandlerDef(this, "controllers.Angebote", "destroyOffer", Seq(classOf[String]), "DELETE", """""", _prefix + """angebotErstellen/$Id<[^/]+>""")
)
                      

// @LINE:10
def createRoute(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.createRoute(), HandlerDef(this, "controllers.Angebote", "createRoute", Seq(), "POST", """""", _prefix + """angebotErstellen""")
)
                      

// @LINE:8
def myOffers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Angebote.myOffers(), HandlerDef(this, "controllers.Angebote", "myOffers", Seq(), "GET", """""", _prefix + """meineAngebote""")
)
                      
    
}
                          

// @LINE:27
// @LINE:22
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def about(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.about(), HandlerDef(this, "controllers.Application", "about", Seq(), "GET", """""", _prefix + """about""")
)
                      

// @LINE:22
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:27
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """""", _prefix + """assets/javascripts/routes""")
)
                      
    
}
                          

// @LINE:20
class ReverseAngeboteSuchen {
    

// @LINE:20
def angeboteSuchen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AngeboteSuchen.angeboteSuchen(), HandlerDef(this, "controllers.AngeboteSuchen", "angeboteSuchen", Seq(), "POST", """""", _prefix + """angeboteSuchen""")
)
                      
    
}
                          
}
        
    