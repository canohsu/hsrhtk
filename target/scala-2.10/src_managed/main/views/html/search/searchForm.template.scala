
package views.html.search

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
object searchForm extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main/*1.6*/ {_display_(Seq[Any](format.raw/*1.8*/("""

<!-- 麵包屑 -->
<div class="breadcrumbs">
<div class="container crumb">
	<div class="col-xs-12">
		<a href="http://www.eztravel.com.tw/"><img src=""""),_display_(Seq[Any](/*7.52*/routes/*7.58*/.Assets.at("images/common/icon_home.png"))),format.raw/*7.99*/("""" style="padding-right: 4px;">首頁</a> &gt; 
		<a href="http://www.eztravel.com.tw/package1/index.htm?in=tb4">國內旅遊</a> &gt; 
		高鐵自主遊
	</div>
</div>
</div>

<!-- Search -->
<div class="search-area">
	<div class="container">
		<div class="search-form">
		<form class="form-horizontal" method="get" action="/hsrhtl/searchlist">
		<fieldset>

            <div class="row">
                <div class="col-xs-12 search-form-line">
                    <img src=""""),_display_(Seq[Any](/*23.32*/routes/*23.38*/.Assets.at("images/icon/hotel/searchFormTitle.png"))),format.raw/*23.89*/("""">
                </div>
            </div>
<!--
			<div class="row">
                <div class="col-xs-12 col-sm-2 col-md-1 search-form-title">出發站</div>
				<div class="col-xs-12 col-sm-10 col-md-2"><select class="form-control" id="placeFrom" name="placeFrom"></select></div>
				<div class="col-xs-12 col-sm-2 col-md-1 search-form-title">目的地</div>
                <div class="col-xs-12 col-sm-5 col-md-2"><select class="form-control" id="arrCity" name="arrCity"></select></div>
                <div class="col-xs-12 col-sm-5 col-md-2"><select class="form-control" id="placeTo" name="placeTo"></select></div>
                <div class="col-xs-12 col-sm-2 col-md-2 search-form-title">車廂種類</div>
                <div class="col-xs-12 col-sm-10 col-md-2">
                <select class="form-control input-md" id="carClass" name="carClass" disabled>
					<option value="STANDARD" selected>標準車廂</option>
				</select>
                </div>
			</div>


<div style="background-color: #FAFAFA;display:none;">
<br><br><br>
            <div class="row">
                <div class="col-xs-1 search-form-title" style="background-color: #aaaaaa;">飯店名稱</div>
                <div class="col-xs-1" style="background-color: #0000ff;"><input type="text" ></div>
                <div class="col-xs-1" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-1" style="background-color: #0000ff;"><input type="text" ></div>
                <div class="col-xs-1" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-1" style="background-color: #0000ff;"><input type="text" ></div>
                
                <div class="col-xs-1" style="background-color: #FAFAFA;"><input type="text" ></div>
                <div class="col-xs-1"><input type="text" ></div>
                <div class="col-xs-1"><input type="text" ></div>
                <div class="col-xs-1"><input type="text" ></div>
                <div class="col-xs-1"><input type="text" ></div>
                <div class="col-xs-1"><input type="text" ></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-2 search-form-title" style="background-color: #aaaaaa;">飯店名稱</div>
                <div class="col-xs-2" style="background-color: #0000ff;"><input type="text" ></div>
                <div class="col-xs-2" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-2" style="background-color: #0000ff;"><input type="text" ></div>
                <div class="col-xs-2" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-2" style="background-color: #0000ff;"><input type="text" ></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-3 search-form-title" style="background-color: #aaaaaa;">飯店名稱</div>
                <div class="col-xs-3" style="background-color: #0000ff;"><input type="text" ></div>
                <div class="col-xs-3" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-3" style="background-color: #0000ff;"><input type="text" ></div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-1" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-2" style="background-color: #0000ff;"><input type="text" ></div>
                <div class="col-xs-3" style="background-color: #000000;"><input type="text" ></div>
                <div class="col-xs-6" style="background-color: #0000ff;"><input type="text" ></div>
            </div>
            
            <div class="row">
                <div class="col-xs-12" style="background-color: #dddddd;">12345</div>
            </div>
</div>
-->

            <div class="row">
                <div class="col-xs-12 col-sm-3 col-sm-offset-1">
                <div class="row">
                <div class="col-xs-12">
                <label>出發站</label><select id="placeFrom" name="placeFrom"></select>
                </div>
                </div>
                </div>

                <div class="col-xs-12 col-sm-5">
                <div class="row">
                <div class="col-xs-6 col-sm-5">
                <label>目的地</label><select id="arrCity" name="arrCity"></select>
                </div>
                <div class="col-xs-6 col-sm-7">
                <label class="none"></label><select id="placeTo" name="placeTo"></select>
                </div>
                </div>
                </div>

                <div class="col-xs-12 col-sm-2">
                <label>車廂種類</label><select id="carClass" name="carClass"><option value="STANDARD" selected>標準車廂</option></select>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1"><hr></div>
            </div>

			<div class="row">
                <div class="col-xs-12 col-sm-3 col-sm-offset-1">
                <label>去程日期</label><div class="input-append date"><input type="text" id="depDate" name="depDate"></div>
				</div>

                <div class="col-xs-12 col-sm-5">
                <div class="row">
                <div class="col-xs-6 col-sm-5">
                <label>旅遊天數</label>
					<select id="travelDay" name="travelDay">
						<option value="2" selected>2</option>
						<option value="3">3</option>
					</select>
                </div>
                <div class="col-xs-6 col-sm-7">
                <label>回程日期</label><input type="text" id="returnDate" name="returnDate" readonly class="none">
                </div>
                </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1"><hr></div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-5 col-sm-offset-1">
                <label>飯店名稱</label>
					<select id="" name="hotelNo">
					   <option value="" selected>不拘</option>
					   <option value="HTLI000002500">高雄玫瑰森林時尚旅館</option>
					</select>
                    <br>
                </div>
			</div>

			<div class="row">
				<div class="form-actions col-xs-12">
                <div id="roomTable"></div>
                </div>
			</div>

            <div class="row">
                <div class="col-xs-12 col-md-4 col-md-offset-1" style="padding-top: 10px;">
					<button type="button" id="addRoom"><img src=""""),_display_(Seq[Any](/*162.52*/routes/*162.58*/.Assets.at("images/icon/hotel/searchFormPlus.png"))),format.raw/*162.108*/(""""> 新增飯店房型</button>
					<a href="#"><img src=""""),_display_(Seq[Any](/*163.29*/routes/*163.35*/.Assets.at("images/icon/hotel/searchFormInfo.png"))),format.raw/*163.85*/(""""> 高鐵票種說明</a>
                </div>
            </div>

			<div class="row">
				<div class="form-actions col-xs-12" style="padding-top: 10px;text-align:center;">
					<button type="submit" class="search-form-submit"></button>
				</div>
			</div>

		</fieldset>
		</form>
        </div>
        
	</div><!-- end container -->
</div><!-- end search-area -->


<div class="event-area">
	<div class="event-row container">
		<div class="col-sm-12" style="text-align: center">
			<p style="font-size: 4em; font-weight: 500;">Marketing stuff!</p>
			<p style="font-size: 1.8em; font-weight: 200;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
		</div>
	</div>
	<div class="event-row container">
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*189.55*/routes/*189.61*/.Assets.at("images/common/sample_event3.png"))),format.raw/*189.106*/(""""></div>
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*190.55*/routes/*190.61*/.Assets.at("images/common/sample_event2.png"))),format.raw/*190.106*/(""""></div>
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*191.55*/routes/*191.61*/.Assets.at("images/common/sample_event.png"))),format.raw/*191.105*/(""""></div>
	</div>
	<div class="event-row container">
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*194.55*/routes/*194.61*/.Assets.at("images/common/sample_event.png"))),format.raw/*194.105*/(""""></div>
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*195.55*/routes/*195.61*/.Assets.at("images/common/sample_event2.png"))),format.raw/*195.106*/(""""></div>
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*196.55*/routes/*196.61*/.Assets.at("images/common/sample_event3.png"))),format.raw/*196.106*/(""""></div>
	</div>
	<div class="event-row container">
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*199.55*/routes/*199.61*/.Assets.at("images/common/sample_event.png"))),format.raw/*199.105*/(""""></div>
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*200.55*/routes/*200.61*/.Assets.at("images/common/sample_event3.png"))),format.raw/*200.106*/(""""></div>
		<div class="col-md-4 col-sm-4 col-xs-12"><img src=""""),_display_(Seq[Any](/*201.55*/routes/*201.61*/.Assets.at("images/common/sample_event2.png"))),format.raw/*201.106*/(""""></div>
	</div>
	<div class="container">
		<div class="col-md-12" style="font-size: 1.3em; margin-top: 25px; text-align: center;"><a href="#">更多</a></div>
	</div>
</div><!-- end event-area -->






<div style="background-color: #FAFAFA;display:none;">

<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br>


<hr>

<!-- 麵包屑 -->
<div class="breadcrumbs">
<div class="container crumb">
    <div class="col-xs-6 col-md-6" style="padding-left: 0px;">
        <a href="http://www.eztravel.com.tw/">首頁</a> &gt; 
        <a href="http://www.eztravel.com.tw/package1/index.htm?in=tb4">國內旅遊</a> &gt; 
        <a href="#">高鐵自主行</a> &gt; 
        <a href="#">目的城市</a>
    </div>
    <div class="col-xs-6 col-md-6" style="text-align: right; padding-right: 0px;">
        <a href="javascript:window.print();">列印本頁</a>
        轉寄好友
        同步溝通
    </div>
</div>
</div>


<hr>




<!-- 搜尋條件 - Start -->
<div class="container search-result-block">

<div class="row">
	<div class="col-xs-12 form-group text-center">

    <div class="row">
        <div class="col-xs-12">
            <img src=""""),_display_(Seq[Any](/*252.24*/routes/*252.30*/.Assets.at("images/icon/hotel/searchResultTitle.png"))),format.raw/*252.83*/("""">
        </div>
    </div>

    <div class="search-result-form">

    <div class="row search-result-form-bg">
        <div class="col-xs-12 col-sm-10 col-sm-offset-1 search-result">


    <div class="row">

<!-- HSR - Start -->
        <div class="col-xs-12 col-sm-6 hsr">

        <div class="row"><div class="col-xs-12 title"><img src=""""),_display_(Seq[Any](/*267.66*/routes/*267.72*/.Assets.at("images/icon/hotel/searchResultHsr.png"))),format.raw/*267.123*/(""""></div></div>

        <div class="row">
            <div class="col-xs-12">
        
            <div class="row">
                <div class="col-xs-12 col-md-4">
                    <span>起訖</span><p>台北 <img src=""""),_display_(Seq[Any](/*274.53*/routes/*274.59*/.Assets.at("images/icon/hotel/searchResultHsrArrow.png"))),format.raw/*274.115*/(""""> 左營</p>
                </div>
                <div class="col-xs-6 col-md-4">
                    <span>去程</span><p>2013/01/01 (一)</p>
                </div>
                <div class="col-xs-6 col-md-4">
                    <span>回程</span><p>2013/01/03 (三)</p>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12"><span>票種</span>
                    <ul><li>成人 1 人</li><li>孩童 1 人</li><li>愛心 1 人</li><li>敬老 1 人</li></ul>
                </div>
            </div>

            </div>
        
        </div>

        </div>
<!-- HSR - End -->


<!-- HTL - Start -->
        <div class="col-xs-12 col-sm-6 htl">

        <div class="row"><div class="col-xs-12 title"><img src=""""),_display_(Seq[Any](/*301.66*/routes/*301.72*/.Assets.at("images/icon/hotel/searchResultHtl.png"))),format.raw/*301.123*/(""""></div></div>

        <div class="row">
            <div class="col-xs-12">
        
            <div class="row">
                <div class="col-xs-12 col-md-3"><span>區域</span><p>高雄</p></div>
                <div class="col-xs-6 col-md-4"><span>入住</span><p>2013/01/01 (一)</p></div>
                <div class="col-xs-6 col-md-4"><span>退房</span></span><p>2013/01/03 (三)</p></div>
            </div>
            <div class="row">
	           <div class="col-xs-12"><span>房型</span>
                    <ul><li>成人 1 人</li><li>孩童 1 人</li><li>愛心 1 人</li><li>敬老 1 人</li></ul>
	           </div>
            </div>

        </div>
        </div>

        </div>
<!-- HTL - End -->
    </div>



        </div>
    </div>
    </div>


    <div class="row">
        <div class="col-xs-12 textEditDiv"><a href="javascript:history.go(-1);">修改</a></div>
    </div>

</div>
</div>
</div>
<!-- 搜尋條件 - End -->

<hr>


<div class="container search-result-block">
    <div class="row">
        <div class="col-xs-12">
            <div class="search-result-htlList">
                <div class="row"><div class="col-xs-12 title">台東酒店</div></div>
                <div class="row" style="padding-top: 10px;">
                    <div class="col-xs-12 col-md-4"><img src="http://www.eztravel.com.tw/ss_static/images/htl/more/HTLI000002098_m02.jpg" class="htlImages"></div>
                    <div class="col-xs-12 col-md-5">
                        <div class="row" style="padding-bottom: 8px;">
                        <div class="col-xs-12">
                        <a href="" target="_blank"><img src=""""),_display_(Seq[Any](/*353.63*/routes/*353.69*/.Assets.at("images/common/icon_hotel.png"))),format.raw/*353.111*/("""" style="padding-right: 4px; margin-left: -15px;">飯店資訊</a>
                        <a href="" target="_blank"><img src=""""),_display_(Seq[Any](/*354.63*/routes/*354.69*/.Assets.at("images/common/icon_map.png"))),format.raw/*354.109*/("""" style="padding: 0px 4px 0px 8px;">地圖</a>
                        </div>
                        </div>

                        <div class="row review">
                        <div class="col-xs-12">整體評價<span class="score">9.9</span>/10　<span class="visible-xs visible-sm"></span><span>分數源自 302 條評鑑</span>　<a href="http://www.eztravel.com.tw/ezReview/reviewCollect/reviewViewList.do?prodNo=HTLI000000661" target="_blank">查看評鑑</a>
                        </div>
                        </div>
                        
                        <div class="search-result-roomList">

                        <div class="row">
                        <div class="col-xs-12 roomDiv01">
                            <div class="row">
                            <div class="col-xs-10 htitle">精緻客房四人床<img src=""""),_display_(Seq[Any](/*368.77*/routes/*368.83*/.Assets.at("images/common/icon_info.png"))),format.raw/*368.124*/("""" style="padding-left: 8px;"></div>
                            <div class="col-xs-2 edit"><a href="#">修改</a></div>
                            </div>
                            <div class="row">
                            <div class="col-xs-12 btitle">一大床，中西式自助式早餐</div>
                            </div>
                            <div class="row">
                            <div class="col-xs-12 ttitle">票種：成人 2 孩童 1</div>
                            </div>
                        </div>
                        </div>

                        <div class="row">
                        <div class="col-xs-12 roomDiv02">
                            <div class="row">
                            <div class="col-xs-10 htitle">精緻客房四人床<img src=""""),_display_(Seq[Any](/*383.77*/routes/*383.83*/.Assets.at("images/common/icon_info.png"))),format.raw/*383.124*/("""" style="padding-left: 8px;"></div>
                            <div class="col-xs-2 edit"><a href="#">修改</a></div>
                            </div>
                            <div class="row">
                            <div class="col-xs-12 btitle">一大床，中西式自助式早餐</div>
                            </div>
                            <div class="row">
                            <div class="col-xs-12 ttitle">票種：成人 2 孩童 1</div>
                            </div>
                        </div>

                        <!--<div class="row"><div class="col-xs-12"><hr></div></div>-->
                        
                        </div>

                        </div>
                        
                        
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-3 priceDiv" style="background-color: pink;">
                        <div class="row" style="border: 1px solid red;padding:0px;">
                        <div class="col-xs-9 col-sm-12 col-md-9">組合優惠總價<br>
                        <span>23,456</span> 元
                        </div>
                        <div class="col-xs-3 col-sm-12 col-md-3" style="position: relative;">abcde
                        <div class="saveP">現省 <span>1,000</span>
                        </div>
                        </div>
                        </div>


                        <div class="row saveMore" style="border: 1px solid red;padding:0px;">

                        <div class="col-xs-9 col-sm-12 col-md-9">企業優惠總價<br>
                        <span>12,345</span> 元
	                    </div>
                        <div class="col-xs-3 col-sm-12 col-md-3" style="position: relative;">
                        <div class="saveP">再省 <span>1,2000</span>
                        </div>
                        </div>

                        </div>



                        <div class="row" style="clear:both;">
                        <div class="col-xs-12" style="padding-top: 10px;text-align:center;">
                        <button type="submit" class="orderSubmit"></button>
                        </div>
                        </div>

                    </div><!-- priceDiv -->

                    <!----
                    <div class="col-xs-12 col-md-3 priceDiv">
                        <div class="row">
                        <div class="col-xs-12">組合優惠總價　<span>18,000</span> 元</div>
                        <div class="col-xs-12 saveP"><span>現省</span>2,000</div>
                        </div>

                        <div class="row saveMore">
                        <div class="col-xs-12">組合優惠總價　<span>18,000</span> 元</div>
                        <div class="col-xs-12 saveP"><p><span>再省</span>2,000</p></div>
                        </div>

                        <div class="row">
                        <div class="col-xs-12" style="padding-top: 10px;text-align:center;">
                        <button type="submit" class="orderSubmit"></button>
                        </div>
                        </div>

                    </div>
                    ---->
                </div>
            </div>
        </div>
    </div>
</div>

<hr>

<!-- 高鐵班次資訊 - Start -->
<div class="container search-result-block">
    <div class="css_table">
        <div class="row css_tr">
        <div class="col-xs-1 css_theadTd">去回程</div>
        <div class="col-xs-3 css_theadTd">起訖站</div>
        <div class="col-xs-2 css_theadTd">車次</div>
        <div class="col-xs-2 css_theadTd">日期</div>
        <div class="col-xs-2 css_theadTd">出發時間</div>
        <div class="col-xs-2 css_theadTd">抵達時間</div>
        </div>

        <div class="row css_tr">
            <div class="col-xs-1 css_tbodyTd1">去回程</div>
            <div class="col-xs-3 css_tbodyTd2">起訖站</div>
            <div class="col-xs-2 css_tbodyTd3">車次</div>
            <div class="col-xs-2 css_tbodyTd2">2013/12/12 (一)</div>
            <div class="col-xs-2 css_tbodyTd3">出發時間</div>
            <div class="col-xs-2 css_tbodyTd2">抵達時間</div>
        </div>

        <div class="row css_tr">
            <div class="col-xs-1 css_tbodyTd1">去回程</div>
            <div class="col-xs-3 css_tbodyTd2">起訖站</div>
            <div class="col-xs-2 css_tbodyTd3">車次</div>
            <div class="col-xs-2 css_tbodyTd2">日期</div>
            <div class="col-xs-2 css_tbodyTd3">出發時間</div>
            <div class="col-xs-2 css_tbodyTd2">抵達時間</div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 textEditDiv"><a href="#">修改</a></div>
    </div>
</div>
<!-- 高鐵班次資訊 - End -->

<hr>


<div class="container search-result-block">
    <div class="row">
        <div class="col-xs-12">飯店</div>
    </div>

    <div class="row">
        <div class="col-xs-3 col-md-1">排序方式</div>
        <div class="col-xs-9 col-md-2"><select></select></div>
        <div class="col-xs-12 col-md-9" style="text-align:right;">page</div>
    </div>
</div>


<hr>
</div>









	<script src=""""),_display_(Seq[Any](/*530.16*/routes/*530.22*/.Assets.at("js/searchForm.js"))),format.raw/*530.52*/(""""></script>

""")))}/*532.2*/ {_display_(Seq[Any](format.raw/*532.4*/("""
   <!-- Page Level CSS & JS Put Here -->
    <link href=""""),_display_(Seq[Any](/*534.18*/routes/*534.24*/.Assets.at("css/common/search.css"))),format.raw/*534.59*/("""" rel="stylesheet">
""")))}/*535.2*/ {_display_(Seq[Any](format.raw/*535.4*/("""
	"""),_display_(Seq[Any](/*536.3*/header())),format.raw/*536.11*/("""
""")))}/*537.2*/ {_display_(Seq[Any](format.raw/*537.4*/("""
	"""),_display_(Seq[Any](/*538.3*/footer())),format.raw/*538.11*/("""
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:31 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/search/searchForm.scala.html
                    HASH: 8a6bef406cad81eaaf94c8cfafd1b39227c7589d
                    MATRIX: 876->1|887->5|925->7|1113->160|1127->166|1189->207|1696->678|1711->684|1784->735|8526->7440|8542->7446|8616->7496|8701->7544|8717->7550|8790->7600|9725->8498|9741->8504|9810->8549|9911->8613|9927->8619|9996->8664|10097->8728|10113->8734|10181->8778|10327->8887|10343->8893|10411->8937|10512->9001|10528->9007|10597->9052|10698->9116|10714->9122|10783->9167|10929->9276|10945->9282|11013->9326|11114->9390|11130->9396|11199->9441|11300->9505|11316->9511|11385->9556|12597->10731|12613->10737|12689->10790|13082->11146|13098->11152|13173->11203|13435->11428|13451->11434|13531->11490|14334->12256|14350->12262|14425->12313|16103->13954|16119->13960|16185->14002|16344->14124|16360->14130|16424->14170|17279->14988|17295->14994|17360->15035|18164->15802|18180->15808|18245->15849|23427->20994|23443->21000|23496->21030|23531->21046|23571->21048|23669->21109|23685->21115|23743->21150|23784->21172|23824->21174|23864->21178|23895->21186|23917->21189|23957->21191|23997->21195|24028->21203
                    LINES: 29->1|29->1|29->1|35->7|35->7|35->7|51->23|51->23|51->23|190->162|190->162|190->162|191->163|191->163|191->163|217->189|217->189|217->189|218->190|218->190|218->190|219->191|219->191|219->191|222->194|222->194|222->194|223->195|223->195|223->195|224->196|224->196|224->196|227->199|227->199|227->199|228->200|228->200|228->200|229->201|229->201|229->201|280->252|280->252|280->252|295->267|295->267|295->267|302->274|302->274|302->274|329->301|329->301|329->301|381->353|381->353|381->353|382->354|382->354|382->354|396->368|396->368|396->368|411->383|411->383|411->383|558->530|558->530|558->530|560->532|560->532|562->534|562->534|562->534|563->535|563->535|564->536|564->536|565->537|565->537|566->538|566->538
                    -- GENERATED --
                */
            