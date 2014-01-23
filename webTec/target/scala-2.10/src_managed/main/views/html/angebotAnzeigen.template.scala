
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
object angebotAnzeigen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Route,Form[Request],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(Route:  Route)(requestForm: Form[Request]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.45*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("HöriMit")/*6.17*/ {_display_(Seq[Any](format.raw/*6.19*/("""
<div class="starter-template">
    <h1>Aktuelle Angebote</h1>
</div>
<div id=""""),_display_(Seq[Any](/*10.11*/{Route._id})),format.raw/*10.22*/("""" class="cold-md-12">
	"""),_display_(Seq[Any](/*11.3*/_displayOffer(Route)/*11.23*/("")/*11.27*/("4"))),format.raw/*11.32*/("""

"""),_display_(Seq[Any](/*13.2*/Route/*13.7*/.wegpunkteForm.add(0, Route.startAdresse.fetch().name))),format.raw/*13.61*/("""

	<div class="col-md-4">
     """),_display_(Seq[Any](/*16.7*/helper/*16.13*/.form(action = routes.Requests.createRequest(Route._id), 'Id -> "request", 'class -> "form")/*16.105*/ {_display_(Seq[Any](format.raw/*16.107*/("""
       
        <fieldset>
            <legend>Anfrage verschicken</legend>
	            """),_display_(Seq[Any](/*20.15*/inputText(
	                requestForm("seats"), 
	                'placeholder -> "Ben�tigte Sitzpl�tze",
	                'class -> "form-control",
	                'type -> "number",
	                'max -> Route.seats,
	                'min -> "1",
	                '_label -> "Sitzpl�tze", 
	                '_error -> requestForm.error("seats"),
	                '_class -> "form-group",
   	                '_help -> ""
	                
	            ))),format.raw/*32.15*/("""
				"""),_display_(Seq[Any](/*33.6*/select(
				   requestForm("startAddressForm"),
				   options = options(Route.wegpunkteForm),
				   'class -> "form-control",				
				   '_label -> "Von",
	                '_class -> "form-group",
	                '_help -> ""
				))),format.raw/*40.6*/("""
			"""),_display_(Seq[Any](/*41.5*/{Route.wegpunkteForm.add(Route.zielAdresse.fetch().name);val meh =Route.wegpunkteForm.remove(0)})),format.raw/*41.101*/("""
				"""),_display_(Seq[Any](/*42.6*/select(
				   requestForm("destinationAddressForm"),
				   options = options(Route.wegpunkteForm),
	                'class -> "form-control", 
				   '_label -> "Nach",
				   '_class -> "form-group",			
   	                '_help -> ""
				))),format.raw/*49.6*/("""
        </fieldset>
        <div class="actions form-group">
			<input type="submit" class="btn btn-default" id="abschicken" value="Mitfahrgelegenheit anfragen.">
			<input type="hidden" value=""""),_display_(Seq[Any](/*53.33*/{Route._id})),format.raw/*53.44*/("""" class="omm_value-offer">
		</div>

    """)))})),format.raw/*56.6*/("""		

	</div>
</div>
	<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjsbaoEWBxF2oxvLEenqLjERjfJICyyWg&sensor=true">
	</script>
 	<script type="text/javascript" src="/assets/javascripts/omm_mapCanvases.js"></script>
 	<script type="text/javascript" src="/assets/javascripts/main.js"></script>
 	
 """)))})))}
    }
    
    def render(Route:Route,requestForm:Form[Request]): play.api.templates.HtmlFormat.Appendable = apply(Route)(requestForm)
    
    def f:((Route) => (Form[Request]) => play.api.templates.HtmlFormat.Appendable) = (Route) => (requestForm) => apply(Route)(requestForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 16:30:07 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec/webTec/app/views/angebotAnzeigen.scala.html
                    HASH: 933aeb24002f73ad951e4ca91246e3543fbe61de
                    MATRIX: 797->1|986->44|1016->101|1053->104|1076->119|1115->121|1235->205|1268->216|1328->241|1357->261|1370->265|1397->270|1437->275|1450->280|1526->334|1596->369|1611->375|1713->467|1754->469|1885->564|2380->1037|2422->1044|2684->1285|2725->1291|2844->1387|2886->1394|3158->1645|3394->1845|3427->1856|3503->1901
                    LINES: 26->1|32->1|34->5|35->6|35->6|35->6|39->10|39->10|40->11|40->11|40->11|40->11|42->13|42->13|42->13|45->16|45->16|45->16|45->16|49->20|61->32|62->33|69->40|70->41|70->41|71->42|78->49|82->53|82->53|85->56
                    -- GENERATED --
                */
            