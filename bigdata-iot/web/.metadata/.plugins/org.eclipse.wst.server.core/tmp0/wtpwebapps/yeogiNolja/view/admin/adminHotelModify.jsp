<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-box2 icon-gradient bg-amy-crisp"> </i>
			</div>
			<div>
				${hotelDetail.name}
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
			<form action="adminHotelModifyImpl.mc" method="post">
				<h5 class="card-title">Modify Hotel Information</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>ID</th>
							<th>${hotelDetail.hotel_id}
								<input type="hidden" name="hotel_id" value="${hotelDetail.hotel_id}">
							</th>
						</tr>
						<tr>
							<th>NAME</th>
							<td><input id="title" name="name" type="text" class="form-control"
								value="${hotelDetail.name}"/>
							</td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td><input id="title" name="addr_sd" type="text" class="form-control-address"
								value="${hotelDetail.addr_sd}"/>
								<input id="title" name="addr_sgg" type="text" class="form-control-address"
								value="${hotelDetail.addr_sgg}"/>
								<input id="title" name="addr_emd" type="text" class="form-control-address"
								value="${hotelDetail.addr_emd}"/>
							</td>
						</tr>
						<tr>
							<th>Total ROOMS</th>
							<td><input id="title" name="total_room" type="text" class="form-control"
								value="${hotelDetail.total_room}"/>
							</td>
						</tr>
						<tr>
							<th>Longitude</th>
							<td><input id="title" name="lon" type="text" class="form-control"
								value="${hotelDetail.lon}"/>
							</td>
						</tr>
						<tr>
							<th>Latitude</th>
							<td><input id="title" name="lat" type="text" class="form-control"
								value="${hotelDetail.lat}"/>
							</td>
						</tr>
						<tr>
							<th>AMENITIES</th>
							<td>
								<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox1" name="amenities" class="custom-control-input"
									value=" 실내수영장" checked /> <label class="custom-control-label" 
									for="exampleCustomCheckbox1"> 실내수영장 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox2" name="amenities" class="custom-control-input"
									value=" 레스토랑" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox2"> 레스토랑 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox3" name="amenities" class="custom-control-input"
									value=" 회의실" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox3"> 회의실 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox4" name="amenities" class="custom-control-input"
									value=" 운동시설" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox4"> 운동시설 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox5" name="amenities" class="custom-control-input"
									value=" 무료와이파이" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox5"> 무료 와이파이 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox6" name="amenities" class="custom-control-input"
									value=" 주차장" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox6"> 주차장 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox7" name="amenities" class="custom-control-input"
									value=" 반려동물동반" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox7"> 반려동물 동반 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox8" name="amenities" class="custom-control-input"
									value=" 카페" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox8"> 카페 </label>
							</div>
							</td>
						</tr>
						<tr>
							<th>Grade</th>
							<td>
								<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio1" class="custom-control-input"
									name="grade" value="1급" checked /> <label class="custom-control-label"
									for="exampleCustomRadio1"> 1급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio2" class="custom-control-input"
									name="grade" value="2급" /> <label class="custom-control-label"
									for="exampleCustomRadio2"> 2급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio3" class="custom-control-input"
									name="grade" value="3급" /> <label class="custom-control-label"
									for="exampleCustomRadio3"> 3급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio4" class="custom-control-input"
									name="grade" value="4급" /> <label class="custom-control-label"
									for="exampleCustomRadio4"> 4급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio5" class="custom-control-input"
									name="grade" value="5급" /> <label class="custom-control-label"
									for="exampleCustomRadio5"> 5급 </label>
							</div>
							</td>
						</tr>
						<tr>
							<th>Image</th>
							<td><img src="img/hotel/${hotelDetail.hotel_img }" width=50%></td>
						</tr>
						<tr>
							<th>Image File</th>
							<td><input id="title" name="hotel_img" type="text" class="form-control"
								value="${hotelDetail.hotel_img}"/>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="card-footer d-block clearfix">
				<div class="float-right">
					<button type="submit" class="mb-2 mr-2 btn btn-primary btn-lg btn-block">Modify </button>
				</div>
			</div>
			</form>
			</div>
		</div>
	</div>
</div>
