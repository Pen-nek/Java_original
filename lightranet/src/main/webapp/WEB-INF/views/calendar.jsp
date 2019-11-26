<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 	<link href="/resources/css/classic.css" rel="stylesheet"> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@include file="includes/header.jsp"%>

			<main class="content">
				<div id='calendar'></div>
			</main>
		</div>
	</div>
	
	
	
	<script src="/resources/js/app.js"></script>
	
	<link href="/resources/js/fullcalendar/packages/core/main.css" rel="stylesheet">
	<link href="/resources/js/fullcalendar/packages/daygrid/main.css" rel="stylesheet">
	<link href="/resources/js/fullcalendar/packages/timegrid/main.css" rel="stylesheet">
	<link href="/resources/js/fullcalendar/packages/list/main.css" rel="stylesheet">
	<script src="/resources/js/fullcalendar/packages/core/main.js"></script>
	<script src="/resources/js/fullcalendar/packages/core/locales-all.js"></script>
	<script src="/resources/js/fullcalendar/packages/interaction/main.js"></script>
	<script src="/resources/js/fullcalendar/packages/daygrid/main.js"></script>
	<script src="/resources/js/fullcalendar/packages/timegrid/main.js"></script>
	<script src="/resources/js/fullcalendar/packages/moment/main.js"></script>
	<script src="/resources/js/fullcalendar/packages/list/main.js"></script>

	<script>

		var calendar;
		
		$(function() { // 화면 로드시 실행
	
			var initialLocaleCode = 'en';
		    var localeSelectorEl = 'ko';
		    var calendarEl = document.getElementById('calendar');
	
		    calendar = new FullCalendar.Calendar(calendarEl, {
		      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
		      header: {
		        left: 'prev,next today',
		        center: 'title',
		        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
		      },
		      editable: true,
		      droppable: true,
		      drop: function(info) {
		    	    // is the "remove after drop" checkbox checked?
		    	    if (checkbox.checked) {
		    	      // if so, remove the element from the "Draggable Events" list
		    	      info.draggedEl.parentNode.removeChild(info.draggedEl);
		    	    }
		    	  },
		      defaultDate: '2019-11-12',
		      locale: localeSelectorEl,
		      buttonIcons: true, // show the prev/next text
		      weekNumbers: true,
		      navLinks: true,
		      editable: true,
		      eventLimit: true,
		      eventClick: function(info) {
		    	/*   alert('Event: ' + info.event.id);
		    	  alert('Event: ' + info.event.title); */
		    	  
		    	  var url="/eventschedule?c_id=" + info.event.id;
				  window.open(url, "", "location=no, menubar=no, status=0, toolbar=0, width=500, height=800, resizable=yes");
				  
		    	  
		    	  //var url = "/eventschedule?c_id=" + info.event.id;
		    	  //window.location.href = url;
		      }	  
		    	  /*
		    	  window.location = 'eventschedule';
		    	    // change the border color just for fun
		    	    info.el.style.borderColor = 'blue'; 
		    	  }
		    	  */
		    
		    });
		    
		      
		    
		   
		    	
		    calendar.render();
		 	// 암튼 controller 에서 보내준걸 화면에 el 형태로 받아서 for문 형태로 돌려서 addevent 해줌
		 	
		 	$(".fc-today-button.fc-button.fc-button-primary").after("<button id='btnAddSchedule' class='fc-button'>일정추가</button>"); 
		    $("#btnAddSchedule").click(function (){
		    	var url="/addschedule"
		    	window.open(url, "", "location=no, menubar=no, status=0, toolbar=0, width=500, height=800, resizable=yes");
		    });
		    /* $(".fc-dayGridMonth-button.fc-button.fc-button-primary.fc-button-active").before("<button id='btnmodify' class='fc-button'>일정수정</button>");
		    $("#btnmodify").click(function (){
		    	var url="/eventschedule?c_id=<c:out value="1"/>"
		    	window.open(url, "", "location=no, menubar=no, status=0, toolbar=0, width=500, height=800, resizable=yes");
		    }); */
		    var result = ${jsonResult}; 
		    for(var i=0; i < result.length; i++){
		    	//console.log(result[i]);
		    	var r = result[i];
		    	var bgColor = "";
		    	switch(r.c_category){
		    		case "프로젝트": bgColor = '#a7a132';
		    		break;
		    		case "휴가": bgColor = '#9580c1';
			    		break;
		    		case "결재 관련": bgColor = '#55b3b9';
			    		break;
		    		case "세액 신고": bgColor = '#fcc100';
			    		break;
		    	}
		    	
		    	calendar.addEvent({'id':r.c_id,'title':r.c_content,'start':r.c_start, 'end':r.c_finish, 'backgroundColor':bgColor, 'borderColor':'#ffffff'});
		    	
				//보낼 때 : var arr = { 'title':'evt4', 'start':'2019-09-04', 'end':'2019-09-06' };
		    	//받을 때 : calendar.addEvent( arr );
		    /* 	 $(".fc-day-grid-event.fc-h-event.fc-event.fc-not-start.fc-end.fc-draggable")("<button id='btnevent' class='fc-event'>일정 수정</button>");
				 $("#btnevent").click(function (){
				   var url=""
				    }  	*/
		    }
		   
		    
	  }); // $(function()) end
		
 	function fn_refresh(){
		location.reload();
	} 

		
	</script>
	
</body>

</html>