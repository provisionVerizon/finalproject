$(document)
		.ready(
				function() {

					// Stops the submit request
					$("#orderDetailsByDate").submit(function(e) {
						e.preventDefault();
					});

					// checks for the button click event
					$("#dateSubmit")
							.click(
									function(e) {

										// get the form data and then serialize
										// that
										dataString = $("#orderDetailsByDate")
												.serialize();

										// get the form data using another
										// method
										var date_val = $("input#dateval").val();
										dataString = "date_val=" + date_val;

										console.log("my data string = "
												+ dataString);
										$
												.ajax({
													type : "GET",
													url : "GetOrderDetailsServlet",
													data : dataString,
													dataType : "json",

													// if received a response
													// from the server
													success : function(data,
															textStatus, jqXHR) {
														console.log("i m here");
														console.log(data);

														$("#content1")
																.html(
																		"<b>Order Details are </b>");
														//		
														var i,k;
														var ss = "<table border=\" 2\"><tr><td>ORDER ID</td><td>DUE DATE</td><td>LINE OF BUSINESS</td></tr>";
														// console.log("aajghhhgaaa");
														for(k=0;k<data.order.length;k++)
														{
														ss += "<tr><td>"
																+ data.order[k].orderdetails.orderid
																+ "</td><td>"
																+ data.order[k].orderdetails.duedate
																+ "</td><td>"
																+ data.order[k].lineofbusiness
																+ "</td></tr>";
														}
														$("#content1").html(ss+"</table>");
														var ss2 = "<table border=\" 2\"><tr><td>SERVICE ID</td><td>CUSTOMER ID</td><td>CUSTOMER NAME</td><td>CUSTOMER TYPE</td><td>STREET NAME</td><td>ZIP CODE</td><td>CITY</td><td>STATE</td><td>STATE ID</td><td>COUNTRY</td><td>CONTACT NO</td></tr>";
														for(k=0;k<data.order.length;k++)
														{
														ss2 += "<tr><td>"
															    + data.order[k].orderdetails.orderid
															    +"</td><td>"
																+ data.order[k].customerdetails.customerid
																+ "</td><td>"
																+ data.order[k].customerdetails.customername
																+ "</td><td>"
																+ data.order[k].customerdetails.customertype
																+ "</td><td>"
																+ data.order[k].customerdetails.connectionaddress.streetname
																+ "</td><td>"
																+ data.order[k].customerdetails.connectionaddress.zipcode
																+ "</td><td>"
																+ data.order[k].customerdetails.connectionaddress.city
																+ "</td><td>"
																+ data.order[k].customerdetails.connectionaddress.state
																+ "</td><td>"
																+ data.order[k].customerdetails.connectionaddress.stateid
																+ "</td><td>"
																+ data.order[k].customerdetails.connectionaddress.country
																+ "</td><td>"
																+ data.order[k].customerdetails.contactnumber
																+ "</td></tr>";
														}
														$("#content1").append(
																ss2+"</table>");
														var ss3 = "<table border=\" 2\"><tr><td>ORDER ID</td><td>SERVICE ID</td><td>SERVICE NAME</td><td>MDN</td><td>QUANTITY</td></tr>";

														var j;
														for(k=0;k<data.order.length;k++)
														{
														for (i = 0; i < data.order[k].orderdetails.services.length; i++) {
															ss3 += "<tr><td>"
																    +data.order[k].orderdetails.orderid
																    +"</td><td>"
																	+ data.order[k].orderdetails.services[i].servicecode
																	+ "</td><td>"
																	+ data.order[k].orderdetails.services[i].servicename
																	+ "</td><td>";
															for (j = 0; j < data.order[k].orderdetails.services[i].mdn.length-1; j++)
																ss3 += data.order[k].orderdetails.services[i].mdn[j]
																		+ " ,";
															ss3 += data.order[k].orderdetails.services[i].mdn[j];
															
															ss3 += "</td><td>"
																	+ data.order[k].orderdetails.services[i].quantity
																	+ "</td></tr>";

														}
														}
														$("#content1").append(
																ss3+"</table>");

														/*
														 * *for(i = 0; i <
														 * data.orderdetails[1].services.length;
														 * i++) { out += "<tr><td>" +
														 * arr[i].Name + "</td><td>" +
														 * arr[i].City + "</td><td>" +
														 * arr[i].Country + "</td></tr>"; }
														 * 
														 *  + "<tr><td>" +
														 * data.cust_id + "</td>" + "<td>" +
														 * data.type + "</td>" + "<td>" +
														 * data.first_name + "</td>" + "<td>" +
														 * data.last_name + "</td>" + "<td>" +
														 * data.address_line1 + "</td>" + "<td>" +
														 * data.city + "</td></tr</table><BR><BR>");
														 */
													},

													// If there was no resonse
													// from the server
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														console
																.log("Something really bad happened "
																		+ textStatus);
														$("#content1")
																.html(
																		jqXHR.responseText
																				+ "   dcdddd");
													},

													// capture the request
													// before it was sent to
													// server
													beforeSend : function(
															jqXHR, settings) {
														// adding some Dummy
														// data to the request
														settings.data += "&dummyData=whatever";
														// disable the button
														// until we get the
														// response
														$('#dateSubmit').attr(
																"disabled",
																true);
													},

													// this is called after the
													// response or error
													// functions are finsihed
													// so that we can take some
													// action
													complete : function(jqXHR,
															textStatus) {
														// enable the button
														$('#dateSubmit').attr(
																"disabled",
																false);
													}

												});
									});

				});