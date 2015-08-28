var arr;
var xmlhttp = new XMLHttpRequest();
var url = "GetDslamDetails";

xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		myFunction(xmlhttp.responseText);
	}
}
xmlhttp.open("GET", url, true);
xmlhttp.send();
function enablePort() {
    alert("Ssss");
}
function myFunction(response) {
	arr = JSON.parse(response);
	//alert(response);
	var i;

	$("#dSlam").empty();
	$("#dSlam").append("<option>Select DSLAM ID</option>");

	for (i = 0; i < arr.dslam.length; i++) {
		$("#dSlam").append(
				"<option value=\"" + arr.dslam[i].dslam_id + "\"> "
						+ arr.dslam[i].dslam_id + "</option>");
		// out2+= "<option >" +arr.pon_detail[i].pon_id +"</option>"
	}
	$("#dOnt").empty();
	$("#dOnt").append("<option>Select ONT ID</option>");
	for (i = 0; i < arr.ont.length; i++) {
		$("#dOnt").append(
				"<option value=\"" + arr.ont[i].ont_id + "\"> "
						+ arr.ont[i].ont_id + "</option>");
		// out2+= "<option >" +arr.pon_detail[i].pon_id +"</option>"
	}

	// out2+="</select>"

}

$(document)
		.ready(
				function() {
					
					$("#dSlam")
							.change(
									function() {
										//alert("Handler for dSlam called.");
										var value = $("#dSlam").val();
										//alert("Handler for dSlam called."
										//		+ value);
										var i;
										$("#dSlampon").empty();
										$("#dSlampon")
												.append(
														"<option>SELECT PON PORT ID</option>");

										for (i = 0; i < arr.pon_detail.length; i++) {
											if (arr.pon_detail[i].dslam_id == value)

												$("#dSlampon")
														.append(
																"<option value=\""
																		+ arr.pon_detail[i].pon_id
																		+ "\"> "
																		+ arr.pon_detail[i].pon_id
																		+ "</option>");
										}
									});

					$("#dOnt")
							.change(
									function() {
										dataString = "name=aditya";
										$
												.ajax({
													type : "GET",
													url : "GetOntDetail",
													data : dataString,
													dataType : "json",

													// if received a response
													// from the server
													success : function(data,
															textStatus, jqXHR) {
														//alert(data.pon_port_id);
														$("#content3").empty();
														var ss = "<table border=\"1px solid black\">";

														ss += "<tr><td>ONT PORT</td><td>"
																+ data.ont_id
																+ "</td><td>"
																+ data.ont_port_status
																+ "</td><td><button name=\"bOnt\" id=\"bOnt\" >";
														if (data.ont_port_status == "running")
															ss += "DISABLE";
														else if (data.ont_port_status == "disable")
															ss += "RUNNING";
														ss += "</button></td></tr>";
														ss + "</table>"
														$("#content3").append(
																ss);
														// $("#content2").append(
														// data.result);
														// $("#content2").append(
														// "</h3>");
													},

													// If there was no resonse
													// from the server
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														console
																.log("Something really bad happened "
																		+ textStatus);

													},

													// capture the request
													// before it was sent to
													// server
													beforeSend : function(
															jqXHR, settings) {
														// adding some Dummy
														// data to the request
														settings.data += "&dummyData=whatever";

													},

													// this is called after the
													// response or error
													// functions are finsihed
													// so that we can take some
													// action
													complete : function(jqXHR,
															textStatus) {

													}

												});
										
										
									});
					$('#bOnt').on("click",function(){
				        alert('hi');
				    });

//					$("#dOnt").on("click", "button.bOnt", function(){
//					    alert("Aaa");
//					});
					
					
					$("#dSlampon")
							.change(
									function() {

										dataString = "name=aditya";
										$
												.ajax({
													type : "GET",
													url : "GetPonDetails",
													data : dataString,
													dataType : "json",

													// if received a response
													// from the server
													success : function(data,
															textStatus, jqXHR) {
														//alert(data.pon_port_id);
														$("#content2").empty();
														var ss = "<table border=\"1px solid black\">";

														ss += "<tr><td>PON PORT</td><td>"
																+ data.pon_port_id
																+ "</td><td>"
																+ data.pon_port_status
																+ "</td><td><button name=\"bPon\" id=\"bPon\">";
														if (data.pon_port_status == "running")
															ss += "DISABLE";
														else if (data.pon_port_status == "disable")
															ss += "RUNNING";
														ss += "</button></td></tr>";
														if (data.data == "yes") {
															ss += "<tr><td>DATA CARD</td><td>"
																	+ data.data_card_id
																	+ "</td><td>"
																	+ data.data_port_status
																	+ "</td><td><button name=\"bData\" id=\"bData\">";
															if (data.data_port_status == "running")
																ss += "DISABLE";
															else if (data.data_port_status == "disable")
																ss += "RUNNING";
															ss += "</button></td></tr>";

														}
														if (data.voice == "yes") {
															ss += "<tr><td>VOICE CARD</td><td>"
																	+ data.voice_card_id
																	+ "</td><td>"
																	+ data.voice_card_status
																	+ "</td><td><button name=\"bVoice\" id=\"bVoice\">";
															if (data.voice_card_status == "running")
																ss += "DISABLE";
															else if (data.voice_card_status == "disable")
																ss += "RUNNING";
															ss += "</button></td></tr>";
														}
														if (data.video == "yes") {
															ss += "<tr><td>VIDEO CARD</td><td>"
																	+ data.video_card_id
																	+ "</td><td>"
																	+ data.video_card_status
																	+ "</td><td><button name=\"bVideo\" id=\"bVideo\">";
															if (data.video_card_status == "running")
																ss += "DISABLE";
															else if (data.video_card_status == "disable")
																ss += "RUNNING";
															ss += "</button></td></tr>";
														}
														ss + "</table>"
														$("#content2").append(
																ss);
														// $("#content2").append(
														// data.result);
														// $("#content2").append(
														// "</h3>");
													},

													// If there was no resonse
													// from the server
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														console
																.log("Something really bad happened "
																		+ textStatus);

													},

													// capture the request
													// before it was sent to
													// server
													beforeSend : function(
															jqXHR, settings) {
														// adding some Dummy
														// data to the request
														settings.data += "&dummyData=whatever";

													},

													// this is called after the
													// response or error
													// functions are finsihed
													// so that we can take some
													// action
													complete : function(jqXHR,
															textStatus) {

													}

												});

									});
				});

/*
 * 
 * 
 * 
 */