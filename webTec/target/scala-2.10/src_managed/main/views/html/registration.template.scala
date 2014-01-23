
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object registration extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(signupForm: Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._

def /*6.2*/title/*6.7*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.11*/("""
    Sign Up <small><a href=""""),_display_(Seq[Any](/*7.30*/routes/*7.36*/.Registration.createUser)),format.raw/*7.60*/("""">Regestrieren</a></small>
""")))};
Seq[Any](format.raw/*1.26*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/main("Regestrierung")/*10.23*/ {_display_(Seq[Any](format.raw/*10.25*/("""
    
    """),_display_(Seq[Any](/*12.6*/helper/*12.12*/.form(action = routes.Registration.createUser, 'class -> "form-group col-md-4")/*12.91*/ {_display_(Seq[Any](format.raw/*12.93*/("""
        
        <fieldset>
            <legend>Konto erstellen</legend>
            
            """),_display_(Seq[Any](/*17.14*/inputText(
                signupForm("username"),
                'placeholder -> "Benutzername",
                'class -> "form-control", 
                '_label -> "Username", 
                '_help -> "",
                '_error -> signupForm.error("username")
            ))),format.raw/*24.14*/("""
            
            """),_display_(Seq[Any](/*26.14*/inputText(
                signupForm("email"), 
                'placeholder -> "E-Mail",
                'class -> "form-control", 
                '_label -> "Email",
                '_help -> "",
                '_error -> signupForm.error("email")
            ))),format.raw/*33.14*/("""
            
            """),_display_(Seq[Any](/*35.14*/inputPassword(
                signupForm("password"),
                'placeholder -> "Passwort",
                'class -> "form-control", 
                '_label -> "Passwort",
                '_help -> ""
            ))),format.raw/*41.14*/("""
            
            """),_display_(Seq[Any](/*43.14*/inputPassword(
                signupForm("repeatPassword"), 
                'class -> "form-control", 
                'placeholder -> "Passwort wiederholen",
                '_label -> "Passwort wiederholen",
                '_help -> "",
                '_error -> signupForm.error("password")
            ))),format.raw/*50.14*/("""
            """),_display_(Seq[Any](/*51.14*/checkbox(
                signupForm("driver"), 
                'class -> "checkbox", 
                '_label -> "Fahrer"
            ))),format.raw/*55.14*/("""
             """),_display_(Seq[Any](/*56.15*/checkbox(
                signupForm("remember"), 
                'class -> "checkbox", 
                '_label -> "Angemeldet bleiben"
            ))),format.raw/*60.14*/("""
            
        </fieldset>
        
        <div class="actions">
            <input type="submit" class="btn btn-default btn-lg" value="Regestrieren">
            <a href=""""),_display_(Seq[Any](/*66.23*/routes/*66.29*/.Application.index)),format.raw/*66.47*/("""" class="btn">Abbrechen</a>
        </div>
        
    """)))})),format.raw/*69.6*/("""
    
""")))})))}
    }
    
    def render(signupForm:Form[User]): play.api.templates.HtmlFormat.Appendable = apply(signupForm)
    
    def f:((Form[User]) => play.api.templates.HtmlFormat.Appendable) = (signupForm) => apply(signupForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 16 21:29:59 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/registration.scala.html
                    HASH: 932ced7a16f12dbb1fdfcea0a602a24d26015a2c
                    MATRIX: 785->1|938->85|950->90|1034->94|1100->125|1114->131|1159->155|1227->25|1257->82|1285->184|1325->189|1355->210|1395->212|1443->225|1458->231|1546->310|1586->312|1727->417|2037->705|2102->734|2397->1007|2462->1036|2713->1265|2778->1294|3118->1612|3169->1627|3332->1768|3384->1784|3561->1939|3784->2126|3799->2132|3839->2150|3930->2210
                    LINES: 26->1|31->6|31->6|33->6|34->7|34->7|34->7|36->1|38->5|39->8|41->10|41->10|41->10|43->12|43->12|43->12|43->12|48->17|55->24|57->26|64->33|66->35|72->41|74->43|81->50|82->51|86->55|87->56|91->60|97->66|97->66|97->66|100->69
                    -- GENERATED --
                */
            