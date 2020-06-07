<template>
    <div class="page-img uvodna">
        <!-- <a href="rihemberk.html"> -->
        <div class="over-image">
            <p>E-HIVE</p>
        </div>
        <!-- </a> -->
        <!--  <img src="../assets/honey-bee.jpg"> -->
    </div>

</template>
<style type="text/css" scoped>

.page-img {
  height: 100vh;
	width:auto;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
}

.uvodna {
  background-image: url('../assets/beehive.jpg');
}

.over-image {
	background-color: rgb(0,0,0);
	background-color: rgba(0,0,0,0.4);
	position: absolute;
	font-size: 45px;
	/* color:#17A2B8; */
  color:white;
	transform: translate(-50%, -50%);
	padding: 0px 10px;
	left: 50%;
	top:50%;
	text-align: center;
}
.over-image p {
  margin-bottom: 0px ;
}
</style>
