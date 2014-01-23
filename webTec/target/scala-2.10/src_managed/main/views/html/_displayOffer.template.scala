
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
object _displayOffer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Route,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(Route:  Route)(what: String)(size: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""

<div class="row">
	
	<div id="map-canvas"""),_display_(Seq[Any](/*5.22*/{Route._id})),format.raw/*5.33*/("""" class="col-md-"""),_display_(Seq[Any](/*5.50*/size)),format.raw/*5.54*/(""" map-canvas" style="height:400px;">
	</div>
	<div class="col-md-"""),_display_(Seq[Any](/*7.22*/size)),format.raw/*7.26*/(""" jumbotron" style="background-color:transparent; margin-bottom:0px">
		<div class="omm_route-details">
			<span class="omm_dateTime">Am """),_display_(Seq[Any](/*9.35*/{Route.dateForm.format("EEEE")})),format.raw/*9.66*/(""", den """),_display_(Seq[Any](/*9.73*/{Route.dateForm.format("dd.MM.yyyy")})),format.raw/*9.110*/(""" um """),_display_(Seq[Any](/*9.115*/{Route.dateForm.format("HH:mm")})),format.raw/*9.147*/("""</span><br/>
			<span class="omm_von">Von:</span> """),_display_(Seq[Any](/*10.39*/{Route.startAdresse.fetch().name})),format.raw/*10.72*/(""" <br/>
				"""),_display_(Seq[Any](/*11.6*/for(z <- 0 until Route.wegpunkteForm.size()) yield /*11.50*/{_display_(Seq[Any](format.raw/*11.51*/("""
					�ber: """),_display_(Seq[Any](/*12.13*/Route/*12.18*/.wegpunkteForm.get(z))),format.raw/*12.39*/("""<br/>
				""")))})),format.raw/*13.6*/("""
			<span class="omm_nach">Nach:</span> """),_display_(Seq[Any](/*14.41*/{Route.zielAdresse.fetch().name})),format.raw/*14.73*/("""<br/>
			<span class="omm_seats">Freie Sitzpl�tze:</span> """),_display_(Seq[Any](/*15.54*/{Route.seats})),format.raw/*15.67*/("""<br/>	
		"""),_display_(Seq[Any](/*16.4*/if(what == "owner")/*16.23*/{_display_(Seq[Any](format.raw/*16.24*/("""
			"""),_display_(Seq[Any](/*17.5*/for(z <- 0 until Route.requests.size()) yield /*17.44*/{_display_(Seq[Any](format.raw/*17.45*/("""
				"""),_display_(Seq[Any](/*18.6*/if(Route.requests.get(z).fetch().status.equals("Anfrage akzeptiert."))/*18.76*/{_display_(Seq[Any](format.raw/*18.77*/("""
					<span class="omm_people">Mitfahrer:</span> """),_display_(Seq[Any](/*19.50*/{Route.requests.get(z).fetch().requestingUser.fetch().username})),format.raw/*19.113*/("""<br/>	
				""")))})),format.raw/*20.6*/("""
			""")))})),format.raw/*21.5*/("""
		""")))})),format.raw/*22.4*/("""
		</div>
		<div class="omm_start-end-waypoints">
			<input type="hidden" class="omm_start-address" value=""""),_display_(Seq[Any](/*25.59*/{Route.startAdresse.fetch().latitude})),format.raw/*25.96*/("""/"""),_display_(Seq[Any](/*25.98*/{Route.startAdresse.fetch().longitude})),format.raw/*25.136*/("""">
			<input type="hidden" class="omm_waypoints-address" value=""""),_display_(Seq[Any](/*26.63*/for(z <- 0 until Route.wegpunkte.size()) yield /*26.103*/{_display_(Seq[Any](_display_(Seq[Any](/*26.105*/Route/*26.110*/.wegpunkte.get(z).fetch.latitude())),format.raw/*26.144*/("""
							  /"""),_display_(Seq[Any](/*27.12*/Route/*27.17*/.wegpunkte.get(z).fetch.longitude())),format.raw/*27.52*/("""//""")))})),format.raw/*27.55*/("""">
			<input type="hidden" class="omm_destination-address" value=""""),_display_(Seq[Any](/*28.65*/{Route.zielAdresse.fetch().latitude})),format.raw/*28.101*/("""/"""),_display_(Seq[Any](/*28.103*/{Route.zielAdresse.fetch().longitude})),format.raw/*28.140*/("""">
		</div>
		"""),_display_(Seq[Any](/*30.4*/if(what == "owner")/*30.23*/{_display_(Seq[Any](format.raw/*30.24*/("""
			<div class="actions">
				<a href=""""),_display_(Seq[Any](/*32.15*/routes/*32.21*/.Angebote.changeOfferForm(Route._id))),format.raw/*32.57*/("""" role="button"><input type="button" class="btn btn-default omm_update-entry" value="Eintrag �ndern"></a>
				<a href=""""),_display_(Seq[Any](/*33.15*/routes/*33.21*/.Angebote.displayOffer(Route._id))),format.raw/*33.54*/("""" role="button"><input type="button" class="btn btn-default omm_update-entry" value="Eintrag �nzeigen"></a>
				<input type="button" class="btn btn-default omm_delete-entry" value="Mitfahrgelegenheit l�schen.">
			</div>
		""")))})),format.raw/*36.4*/("""
		<input type="hidden" class="omm_value-offer" value=""""),_display_(Seq[Any](/*37.56*/{Route._id})),format.raw/*37.67*/("""">
	</div>
"""))}
    }
    
    def render(Route:Route,what:String,size:String): play.api.templates.HtmlFormat.Appendable = apply(Route)(what)(size)
    
    def f:((Route) => (String) => (String) => play.api.templates.HtmlFormat.Appendable) = (Route) => (what) => (size) => apply(Route)(what)(size)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 16 21:29:59 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/_displayOffer.scala.html
                    HASH: 2a037c1eea911f77a513ee14f4234279d39f322b
                    MATRIX: 795->1|932->44|1014->91|1046->102|1098->119|1123->123|1225->190|1250->194|1424->333|1476->364|1518->371|1577->408|1618->413|1672->445|1760->497|1815->530|1863->543|1923->587|1962->588|2012->602|2026->607|2069->628|2112->640|2190->682|2244->714|2340->774|2375->787|2421->798|2449->817|2488->818|2529->824|2584->863|2623->864|2665->871|2744->941|2783->942|2870->993|2956->1056|3000->1069|3037->1075|3073->1080|3220->1191|3279->1228|3317->1230|3378->1268|3480->1334|3537->1374|3586->1376|3601->1381|3658->1415|3707->1428|3721->1433|3778->1468|3813->1471|3917->1539|3976->1575|4015->1577|4075->1614|4127->1631|4155->1650|4194->1651|4272->1693|4287->1699|4345->1735|4502->1856|4517->1862|4572->1895|4830->2122|4923->2179|4956->2190
                    LINES: 26->1|29->1|33->5|33->5|33->5|33->5|35->7|35->7|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|42->14|42->14|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|48->20|49->21|50->22|53->25|53->25|53->25|53->25|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|58->30|58->30|58->30|60->32|60->32|60->32|61->33|61->33|61->33|64->36|65->37|65->37
                    -- GENERATED --
                */
            