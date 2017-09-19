							<%@ page language="java" contentType="text/html; charset=UTF-8"
							    pageEncoding="UTF-8"%>
							    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
							<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
							<html>
							<head>
							<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
							<title>账号详情</title>
							 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
							<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
							<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
							
							</head>
							<body>
							<div>
								<table class="table table-bordered" width="100%">
								
										<th>账号信息</th>
							
									<tr>
										<td>用户名:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.name }"></td>
										<td>手机号:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.mobile_Phone }"></td>
									</tr>
										<tr>
										<td>真实姓名:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.member_name }"></td>
										<td>身份证:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.identity }"></td>
									</tr>
										<tr>
										<td>邀请码:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.invitatioinCode}"></td>
										<td>被邀请码:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.invitedCode}"></td>
									</tr>
										<tr>
										<td>添加时间:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${listmemberByid.create_date }"></td>
										<td>1</td>
										<td>2</td>
									</tr>
							</table>
							<br>
							<table class="table table-bordered" width="100%">
							
										<th>资金信息</th>
							
									<tr>
										<td>可用余额:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${member_account.useable_balance }"></td>
										<td>冻结余额:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${member_account.imuseale_balance }"></td>
									</tr>
										<tr>
										<td>累计收益:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${member_account.total_profit }"></td>
										<td>投资总额:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${member_account.invest_amount }"></td>
									</tr>
										<tr>
										<td>红包金额:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${member_account.bonus_amount }"></td>
										<td>体验金:</td>
										<td><input class="form-control" type="text" placeholder="Readonly input here…" readonly value="${member_account.bbin_amount }"></td>
									</tr>
							</table>
							<br>
							<table class="table table-bordered">
								<tr>
									<th>投资记录</th>
								</tr>
								<tr>
									<th>序号</th>
									<th>投资编号</th>
									<th>投资金额</th>
									<th>投资状态</th>
									<th>投资收益</th>
									<th>投资时间</th>
								</tr>
								<c:forEach items="${subject_purchase_record }" var="spr" varStatus="stat">
								<tr>
									<td>${stat.index+1}</td>
									<td>${spr.serial_number }</td>
									<td>${spr.amount }</td>
									<td>${spr.delflag }</td>
									<td>${spr.interest }</td>
									<td>${spr.create_date }</td>
								</tr>
							</c:forEach>
							</table>
							<br>
							<table class="table table-bordered">
								<tr>
									<th>提现记录</th>
								</tr>
									<tr>
									<th>序号</th>
									<th>提现编号</th>
									<th>提现状态</th>
									<th>提现银行</th>
									<th>提现卡号</th>
									<th>提现时间</th>
								</tr>
								<c:forEach items="${member_withdraw_record }" var="mwr" varStatus="stat">
								<tr>
									<td>${stat.index+1}</td>
									<td>${mwr.serial_number }</td>
									<td><c:if test="${mwr.status==0 }"><font color="red">待付款</font></c:if>
									<c:if test="${mwr.status==1 }"><font color="green">已付款</font></c:if>
									<c:if test="${mwr.status==2 }"><font color="green">打款中</font></c:if>
									<c:if test="${mwr.status==3 }"><font color="red">打款失败</font></c:if>
									</td>
									<td>${mwr.bank_name }</td>
									<td>${mwr.bank_card }</td>
									<td>${mwr.create_date }</td>
								</tr>
								</c:forEach>
							</table>
							<table class="table table-bordered">
								<tr>
									<th>充值记录</th>
								</tr>
									<tr>
									<th>序号</th>
									<th>充值金额</th>
									<th>充值状态</th>
									<th>充值渠道</th>
									<th>充值渠道编号</th>
									<th>充值时间</th>
								</tr>
								<c:forEach items="${member_deposit_record }" var="mdr" varStatus="stat">
								<tr>
									<td>${stat.index+1}</td>
									<td>${mdr.amount }</td>
									<td><c:if test="${mdr.status ==0}"><font color="red">待付款</font></c:if>
									<c:if test="${mdr.status ==1}"><font color="green">充值完成</font></c:if>
									</td>
									<td>${mdr.pay_channel_name }</td>
									<td>${mdr.pay_channel_order_no }</td>
									<td>${mdr. create_date}</td>
								</tr>
								</c:forEach>
							</table>
							</div>
							</body>
							</html>