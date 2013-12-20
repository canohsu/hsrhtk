//---- 出發高鐵站 ---- Start
var hsr = {
	"station" : [ 
		{ "TAIPEI" : ["台北高鐵站"] },
		{ "BANQIAO" : ["板橋高鐵站"] },
		{ "TAOYUAN" : ["桃園高鐵站"] },
		{ "HSINCHU" : ["新竹高鐵站"] },
		{ "TAICHUNG" : ["台中高鐵站"] },
		{ "CHIAYI" : ["嘉義高鐵站"] },
		{ "TAINAN" : ["台南高鐵站"] },
		{ "ZUOYING" : ["左營高鐵站"] }
	]
}

var i = 0;
var appendStr = "";

for ( var i = 0; i < hsr.station.length; i++) {
	var obj = hsr.station[i];
	var stationName;
	var stationValue;

	for ( var key in obj) {
		stationValue = key;
		stationName = obj[key].toString();
		appendStr = appendStr + "<option value='" + stationValue + "'>" + stationName + "</option>";
	}
}

$(appendStr).appendTo($('#placeFrom'));

//---- 出發高鐵站 ---- End


//---- 目的城市與目的高鐵站連動 ---- Start

$(function(){
// 設定連動選單的參數
var options = {
	preselectFirst : "KHH",		// 預設先選擇"台北市(TP1)"
	preselectSecond : 999,
	emptyOption: false
};

// 設定連動選單的選項資料
var selectOptions = {
	"基隆": {
		"key" : "KEE",
		"values" : {
			"台北高鐵站": "TAIPEI",
			"板橋高鐵站": "BANQIAO"
		}
	},
	"台北市": {
		"key" : "TP1",
		"values" : {
			"台北高鐵站": "TAIPEI",
			"板橋高鐵站": "BANQIAO"
		}
	},
	"新北市": {
		"key" : "TP2",
		"values" : {
			"台北高鐵站": "TAIPEI",
			"板橋高鐵站": "BANQIAO"
		}
	},
	"宜蘭": {
		"key" : "YI0",
		"values" : {
			"台北高鐵站": "TAIPEI",
			"板橋高鐵站": "BANQIAO"
		}
	},
	"花蓮": {
		"key" : "HUN",
		"values" : {
			"台北高鐵站": "TAIPEI",
			"板橋高鐵站": "BANQIAO"
		}
	},
	"桃園": {
		"key" : "TA1",
		"values" : {
			"桃園高鐵站": "TAOYUAN"
		}
	},
	"新竹": {
		"key" : "HSZ",
		"values" : {
			"新竹高鐵站": "HSINCHU"
		}
	},
	"苗栗": {
		"key" : "MI1",
		"values" : {
			"新竹高鐵站": "HSINCHU"
		}
	},
	"台中": {
		"key" : "TXG",
		"values" : {
			"台中高鐵站": "TAICHUNG"
		}
	},
	"南投": {
		"key" : "NA0",
		"values" : {
			"台中高鐵站": "TAICHUNG"
		}
	},
	"彰化": {
		"key" : "ZH1",
		"values" : {
			"台中高鐵站": "TAICHUNG"
		}
	},
	"雲林": {
		"key" : "YU1",
		"values" : {
			"嘉義高鐵站": "CHIAYI"
		}
	},
	"嘉義": {
		"key" : "CYI",
		"values" : {
			"嘉義高鐵站": "CHIAYI"
		}
	},
	"台南": {
		"key" : "TNN",
		"values" : {
			"台南高鐵站": "TAINAN"
		}
	},
	"高雄": {
		"key" : "KHH",
		"values" : {
			"左營高鐵站": "ZUOYING"
		}
	},
	"屏東": {
		"key" : "PIF",
		"values" : {
			"左營高鐵站": "ZUOYING"
		}
	},
	"台東": {
		"key" : "TTT",
		"values" : {
			"左營高鐵站": "ZUOYING"
		}
	}		
};

// 產生連動選單的功能
$('#arrCity').doubleSelect('placeTo', selectOptions, options);
});

//---- 目的城市與目的高鐵站連動 ---- End


// ---- 日期選擇器、旅遊日期連動 ---- Start

function dateToYMD(date) {
	// 格式：2013/05/05
	var d = date.getDate();
	var m = date.getMonth() + 1;
	var y = date.getFullYear();
	return '' + y + '/' + (m<=9 ? '0' + m : m) + '/' + (d <= 9 ? '0' + d : d);
}

var nowTemp = new Date();
var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
var nowplus3d = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate()+3, 0, 0, 0, 0);
var nowplus5d = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate()+5, 0, 0, 0, 0);

var checkin = $('#depDate').datepicker({
	language: "zh-TW",
	format: 'yyyy/mm/dd',
	startDate: '+3d',
	endDate: '+90d',
	autoclose: true
}).datepicker('setDate', nowplus3d)		//出發日期預設初始值
	.on('changeDate', function(ev) {
	if (ev.date.valueOf() > now.valueOf()) {
		var newDate = new Date(ev.date)
		newDate.setDate(newDate.getDate() + parseInt($("#travelDay").val()));
		$("#returnDate").val(dateToYMD(newDate));
	}
}).data('datepicker');

$("#returnDate").val(dateToYMD(nowplus5d));	//返回日期預設初始值

$("#travelDay").change(function() {
	var ev = $('#depDate').val();
	if (ev.length != 0)
	{
		var newDate = new Date(ev)
		newDate.setDate(newDate.getDate() + parseInt($("#travelDay").val()));
		$("#returnDate").val(dateToYMD(newDate));
	}
});

// ---- 日期選擇器、旅遊日期連動 ---- End


// ---- 房型與票種連動 ---- Start


var rowCounts = 0;  // 紀錄目前動態欄位總數
var roomLimit = 3;  // 房數上限

$(function() {

	$("#addRoom").click(function() {

		// 增加 tr class:dynamicTr id=trNo0
		var tr = $("<div></div>").addClass("dynamicTr").attr("id", "trNo" + rowCounts);
		var appendStr = '';
		var hr = '<div class="row hr"><div class="col-xs-12 col-sm-10 col-sm-offset-1"><hr></div></div>';

		// 增加 房型
		appendStr = hr + '<div class="row">';
    	appendStr = appendStr + '<div class="col-xs-12 col-sm-2 col-sm-offset-1"><label id="tdNo' + rowCounts + '">第 ' + (rowCounts+1) + ' 間房</label>';
        appendStr = appendStr + '<select class="selRoomType" id="roomType' + rowCounts + '" name="rooms[' + rowCounts + '].roomType">';
        appendStr = appendStr + '<option value="SGL" selected="selected">單人房</option><option value="TWN">雙人房</option><option value="TRP">三人房</option><option value="QUD">四人房</option>';
        appendStr = appendStr + '</select></div>';

		// 增加 票券種類
        var appendTktStr = updateTkt(rowCounts,1);
        appendStr = appendStr + appendTktStr;
        appendStr = appendStr + '<div class="col-sm-1" id="addBtn' + rowCounts + '" style="padding-top: 15px;"><span class="visible-xs"></span></div>';
        appendStr = appendStr + '</div>';
		tr.append(appendStr);

		// 增加 刪除房型鈕
		var btn = $("<button type='button' class='search-form-removeRoom'></button>").attr("rowCount", rowCounts).attr("id", "btn" + rowCounts);
		btn.click(function() {

			// 刪除該按紐所在的整列
			var deleteRow = $(this).attr("rowCount");
			$("#trNo" + deleteRow).remove();

			// 刪除後重新設定後面的編號(包含子元件的所有屬性)
			for (var j = parseInt(deleteRow); j <= rowCounts; j++) {
				var correctRowNo = j - 1;
				$("#trNo" + j).attr("id", "trNo" + correctRowNo);
				$("#tdNo" + j).text("第 " + (correctRowNo+1) + " 間房").attr("id", "tdNo" + correctRowNo);
				$("#addBtn" + j).attr("id", "addBtn" + correctRowNo);
				$("#btn" + j).attr("rowCount", correctRowNo).attr("id", "btn" + correctRowNo);
				$("#roomType" + j).attr("id", "roomType" + correctRowNo).attr("name", "rooms[" + correctRowNo + "].roomType");
				$("#full" + j).attr("id", "full" + correctRowNo).attr("name", "rooms[" + correctRowNo + "].full");
				$("#children" + j).attr("id", "children" + correctRowNo).attr("name", "rooms[" + correctRowNo + "].children");
				$("#half" + j).attr("id", "half" + correctRowNo).attr("name", "rooms[" + correctRowNo + "].half");
				$("#senior" + j).attr("id", "senior" + correctRowNo).attr("name", "rooms[" + correctRowNo + "].senior");
			}

			// 呈現button
			if(rowCounts <= roomLimit)
			{	$("#addRoom").show();	}
			if(rowCounts <= 2)
			{	$("#btn0").hide();	}
			else
			{	$("#btn0").show();	}
			rowCounts--;
		});

			$("#roomTable").append(tr);
			btn.appendTo('#addBtn' + rowCounts);

			// 隱藏button
			if(rowCounts >= roomLimit-1)
			{	$("#addRoom").hide();	}
			if(rowCounts < 1)
			{	$("#btn0").hide();	}
			else
			{	$("#btn0").show();	}

			$("#roomType" + rowCounts + " option[value='TWN']").attr("selected","true");
			$(".selRoomType").trigger("change");
			rowCounts++;
	});

	$('body').on("change", '.selRoomType', function () {
		var roomId = $(this).attr("id");
		var roomType = $(this).val();
		var i = roomId.substr(8);
		var newOp = 0;
		var oriOp = $("#full" + i + " option").size()-1;
        var refresh = false;

		if ( roomType == "SGL" )
		{	newOp=1;}
		else if ( roomType == "TWN" )
		{	newOp=2;}
		else if ( roomType == "TRP" )
		{	newOp=3;}
		else if ( roomType == "QUD" )
		{	newOp=4;}

		if ( oriOp > newOp )
		{
			for (k=newOp; k<oriOp; k++)
			{
				$("#full" + i + " option:last").remove();
				$("#half" + i + " option:last").remove();
				$("#senior" + i + " option:last").remove();
			}
			refresh = true;
		}
		else if ( oriOp < newOp )
		{
			for (k=oriOp+1; k<=newOp; k++)
			{
				$("#full" + i).append($("<option></option>").attr("value", k).text(k));
				$("#half" + i).append($("<option></option>").attr("value", k).text(k));
				$("#senior" + i).append($("<option></option>").attr("value", k).text(k));
			}
			refresh = true;
		}

        if (refresh == true)
        {
            $("#full" + i).val(newOp);
            $("#half" + i).val(0);
            $("#senior" + i).val(0);
        }

	});

function updateTkt(roomNm,limitTkt)
{
	var appendStr = '';
	var tMax = '';		// 判斷票種數量上限
    var rname = 'rooms[' + roomNm + ']';

    for (k=0; k<=limitTkt; k++)
    {	tMax = tMax + '<option value="' + k + '">' + k + '</option>';	}

	appendStr = appendStr + '<div class="col-xs-12 col-sm-8"><div class="row">';

	appendStr = appendStr + '<div class="col-xs-6 col-sm-3"><label>成人</label><select id="full' + roomNm +'" name="' + rname +'.full">' + tMax + '</select></div>';
	//孩童票只能選擇0-2張
	appendStr = appendStr + '<div class="col-xs-6 col-sm-3"><label>孩童<span style="font-size:11px;">(6-11歲)</span></label><select id="children' + roomNm +'" name="' + rname +'.children"><option value="0">0</option><option value="1">1</option><option value="2">2</option></select></div>';
	appendStr = appendStr + '<div class="col-xs-6 col-sm-3"><label>愛心</label><select id="half' + roomNm +'" name="' + rname +'.half">' + tMax + '</select></div>';
	appendStr = appendStr + '<div class="col-xs-6 col-sm-3"><label>敬老<span style="font-size:11px;">(65歲以上)</span></label><select id="senior' + roomNm +'" name="' + rname +'.senior">' + tMax + '</select></div>';

	appendStr = appendStr + '</div></div>';
	
    return appendStr;
}
	//預載一間雙人房、成人票2張
	$("#addRoom").trigger("click");
});

// ---- 房型與票種連動 ---- End


// ---- 表單檢核 ---- Start
$("form").submit(function(){
	var errmsg = "";

	if ($("#placeFrom option:selected").val() == $("#placeTo option:selected").val())
	{   errmsg = "高鐵出發站與目的站不得相同。\n";}

	if (rowCounts < 1)
	{   errmsg = errmsg + "至少選擇一間房。\n";}
	else
	{
		for (k=0; k<rowCounts; k++)
		{
			var full = parseInt($("#full" + k + " option:selected").val()) 
			+ parseInt($("#half" + k + " option:selected").val()) 
			+ parseInt($("#senior" + k + " option:selected").val());
			var children = parseInt($("#children" + k + " option:selected").val());

			var roomType = $("#roomType" + k + " option:selected").val();
			var tktMax = 0;

			if ( roomType == "SGL" )
			{	tktMax=1;}
			else if ( roomType == "TWN" )
			{	tktMax=2;}
			else if ( roomType == "TRP" )
			{	tktMax=3;}
			else if ( roomType == "QUD" )
			{	tktMax=4;}

			if ((full < 1) || (full > tktMax) || ((full+children) < tktMax) )
			{	errmsg = errmsg + "第 " + (k+1) + " 間房：票數與房型不符規定。\n";	}
		}
	}
	
	if (errmsg.length > 0)
	{
		alert(errmsg);
		return false;
	}

});

//---- 表單檢核 ---- End
