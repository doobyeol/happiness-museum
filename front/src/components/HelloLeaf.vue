<template>
	<v-container>
		<p class="mt-10 font-weight-bold text-center text-h3">
			Welcome To The Happiness Museum 🌻
		</p>
		<p class="mt-10 font-weight-bold text-center text-h5">
			행복이란 무엇일까요?
		</p>
		<ul id="stickies">
			<li v-for="item in myHappiness" :key="item.title">
				<span>{{ item.title }}</span>
				<p class="pl-16 ml-10 pt-16 mt-7 caption">- {{ item.name }}</p>
			</li>
		</ul>
	</v-container>
</template>

<script>
export default {
	name: 'HelloLeaf',
	props: {
		msg: String,
	},
	data() {
		return {
			myHappiness: [
				{ title: '선생님이 내 이름을 불러주는 것', name: '두벼리' },
				{ title: '퇴근하고 선생님을 보는 것', name: '두벼리' },
				{ title: '선생님이랑 하루 일과 쫑알쫑알 하기', name: '두벼리' },
				{ title: '선생님이랑 재밌는거 보면서 같이 저녁 먹기', name: '두벼리' },
				{ title: '선생님이랑 산책하기', name: '두벼리' },
				{ title: '선생님이랑 뒹굴거리기', name: '두벼리' },
				{ title: '선생님이랑 애같코 하기', name: '두벼리' },
				{ title: '잘생긴 선생님 얼굴 구경하기', name: '두벼리' },
			],
		};
	},
};
</script>

<style scoped>
ul#stickies {
	display: flow-root;
}
ul#stickies li {
	display: block;
	list-style: none;
	z-index: 1;
	float: left;
	margin: 30px;
	padding: 15px 15px 50px 15px;
	width: 200px;
	height: 200px;
	/* border: 1px solid #bfbfbf; */
	background-color: rgb(255, 231, 125); /* 색상명 값이 맞지 않을 땐 #fafad2 */
	color: black;
	text-decoration: none;
	-webkit-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	-moz-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	-o-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);
	box-shadow: 2px 2px 4px rgba(170, 146, 38, 0.493);
	-webkit-transition: all 0.2s ease-in;
	-moz-transition: all 0.2s ease-in;
	-o-transition: all 0.2s ease-in;
	-ms-transition: all 0.2s ease-in;
	transition: all 0.2s ease-in;
	overflow: hidden;
}

/* ul#stickies li span.sticky {
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 200%;
} */

/* 회전 */
ul#stickies li:nth-child(even) {
	-webkit-transform: rotate(2deg);
	-moz-transform: rotate(2deg);
	-o-transform: rotate(2deg);
	-ms-transform: rotate(2deg);
	transform: rotate(2deg);
}

ul#stickies li:nth-child(odd) {
	-webkit-transform: rotate(-1deg);
	-moz-transform: rotate(-1deg);
	-o-transform: rotate(-1deg);
	-ms-transform: rotate(-1deg);
	transform: rotate(-1deg);
}

ul#stickies li:nth-child(3n) {
	-webkit-transform: rotate(1deg);
	-moz-transform: rotate(1deg);
	-o-transform: rotate(1deg);
	-ms-transform: rotate(1deg);
	transform: rotate(1deg);
}

/* 변형 데모 - 위에 정의한 전환을 이용해서 서서히 변형시킴 */
ul#stickies li:hover {
	cursor: pointer;
	-webkit-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	-moz-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	-o-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	/* -webkit-transform: rotate(0deg) scale(1.25);
	-moz-transform: rotate(0deg) scale(1.25);
	-o-transform: rotate(0deg) scale(1.25);
	-ms-transform: rotate(0deg) scale(1.25);
	transform: rotate(0deg) scale(1.25); */
	z-index: 10;
}
</style>
