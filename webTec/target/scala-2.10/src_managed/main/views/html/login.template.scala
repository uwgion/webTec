
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(loginForm: Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._

def /*6.2*/title/*6.7*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.11*/("""
    Sign Up <small><a href=""""),_display_(Seq[Any](/*7.30*/routes/*7.36*/.Login.login)),format.raw/*7.48*/("""">Regestrieren</a></small>
""")))};
Seq[Any](format.raw/*1.25*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/main("Anmelden")/*10.18*/ {_display_(Seq[Any](format.raw/*10.20*/("""

<div class="starter-template">
    <h1>Bitte hier anmelden</h1>
</div>

   
  """),_display_(Seq[Any](/*17.4*/helper/*17.10*/.form(action = routes.Login.login, 'class -> "form-group col-md-3")/*17.77*/ {_display_(Seq[Any](format.raw/*17.79*/("""
        
        <fieldset>
            <legend>Kontodetails</legend>
            <div class="row">
            """),_display_(Seq[Any](/*22.14*/inputText(
                loginForm("username"), 
                'placeholder -> "Bitte Benutzernamen eingeben.",
                'class -> "form-control",
                '_label -> "Benutzername", 
                '_error -> loginForm.error("username"),
                '_help -> ""
            ))),format.raw/*29.14*/("""
            
            """),_display_(Seq[Any](/*31.14*/inputPassword(
                loginForm("password"), 
                'placeholder -> "Bitte Passwort eingeben.",
                'class -> "form-control",
                '_label -> "Passwort",
                '_help -> ""
            
            ))),format.raw/*38.14*/("""

             """),_display_(Seq[Any](/*40.15*/checkbox(
                loginForm("remember"), 
                'class -> "checkbox",
                '_label -> "Angemeldet bleiben"
            ))),format.raw/*44.14*/("""
            
       
            
            <input type="hidden" value="a@a.a" name="email" />
            
        </fieldset>
        <div class="actions">
			 <input type="submit" class="btn btn-default btn-lg" value="Login">
	         <a href=""""),_display_(Seq[Any](/*53.21*/routes/*53.27*/.Registration.showRegistrationForm)),format.raw/*53.61*/("""" class="btn">Noch nicht regestriert?</a>
		</div>
		</div>
    """)))})),format.raw/*56.6*/("""
	
""")))})))}
    }
    
    def render(loginForm:Form[User]): play.api.templates.HtmlFormat.Appendable = apply(loginForm)
    
    def f:((Form[User]) => play.api.templates.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jan 19 13:18:31 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/login.scala.html
                    HASH: d0ab1c3da3b5c28a1078cfda86f2be05790bcc33
                    MATRIX: 778->1|928->79|940->84|1024->88|1089->118|1103->124|1136->136|1203->24|1231->77|1258->164|1296->167|1321->183|1361->185|1477->266|1492->272|1568->339|1608->341|1758->455|2080->755|2143->782|2416->1033|2468->1049|2639->1198|2927->1451|2942->1457|2998->1491|3094->1556
                    LINES: 26->1|31->6|31->6|33->6|34->7|34->7|34->7|36->1|38->5|39->8|41->10|41->10|41->10|48->17|48->17|48->17|48->17|53->22|60->29|62->31|69->38|71->40|75->44|84->53|84->53|84->53|87->56
                    -- GENERATED --
                */
            