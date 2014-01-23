
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
object _displayRequest extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Request,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(Request: Request)(what: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

<div class="row">
	
	</div>
	<div>
		<div class="omm_request-details col-md-6">
			<span class="omm_request-from">Von Benutzer:</span> """),_display_(Seq[Any](/*8.57*/{Request.requestingUser.fetch().username})),format.raw/*8.98*/(""" <br/>
			<span class="omm_nach">Von:</span> """),_display_(Seq[Any](/*9.40*/{Request.startAddress.fetch().name})),format.raw/*9.75*/("""<br/>
			<span class="omm_nach">Nach:</span> """),_display_(Seq[Any](/*10.41*/{Request.destinationAddress.fetch().name})),format.raw/*10.82*/("""<br/>
			<span class="omm_seats">Ben�tigte Sitzpl�tze:</span> """),_display_(Seq[Any](/*11.58*/{Request.seats})),format.raw/*11.73*/("""<br/>	
			<span class="omm_status">Status:</span> """),_display_(Seq[Any](/*12.45*/{Request.status})),format.raw/*12.61*/("""<br/>									
		</div>
		"""),_display_(Seq[Any](/*14.4*/if(what == "owner")/*14.23*/{_display_(Seq[Any](format.raw/*14.24*/("""
			<div class="actions col-md-6">
			 """),_display_(Seq[Any](/*16.6*/helper/*16.12*/.form(action = routes.Requests.processRequest(Request._id, "0"), 'Id -> "request", 'class -> "form")/*16.112*/ {_display_(Seq[Any](format.raw/*16.114*/("""
		        <div class="actions form-group">
					<input type="submit" class="btn btn-default" id="abschicken" value="Anfrage akzeptieren.">
				</div>
    		""")))})),format.raw/*20.8*/("""		
			 """),_display_(Seq[Any](/*21.6*/helper/*21.12*/.form(action = routes.Requests.processRequest(Request._id, "1"), 'Id -> "request", 'class -> "form")/*21.112*/ {_display_(Seq[Any](format.raw/*21.114*/("""
		        <div class="actions form-group">
					<input type="submit" class="btn btn-default" id="abschicken" value="Anfrage ablehnen.">
				</div>
    		""")))})),format.raw/*25.8*/("""	
			</div>
		""")))})),format.raw/*27.4*/("""
	</div>"""))}
    }
    
    def render(Request:Request,what:String): play.api.templates.HtmlFormat.Appendable = apply(Request)(what)
    
    def f:((Request) => (String) => play.api.templates.HtmlFormat.Appendable) = (Request) => (what) => apply(Request)(what)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 16 21:29:59 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/_displayRequest.scala.html
                    HASH: 50147ebb929b6e56a710dc79ec84648d7d39d7bb
                    MATRIX: 792->1|918->33|1098->178|1160->219|1242->266|1298->301|1381->348|1444->389|1544->453|1581->468|1669->520|1707->536|1771->565|1799->584|1838->585|1915->627|1930->633|2040->733|2081->735|2274->897|2318->906|2333->912|2443->1012|2484->1014|2674->1173|2722->1190
                    LINES: 26->1|29->1|36->8|36->8|37->9|37->9|38->10|38->10|39->11|39->11|40->12|40->12|42->14|42->14|42->14|44->16|44->16|44->16|44->16|48->20|49->21|49->21|49->21|49->21|53->25|55->27
                    -- GENERATED --
                */
            