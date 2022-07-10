<template>
	<v-container>
		<p class="mt-10 font-weight-bold text-center text-h3">
			Welcome To The Happiness Museum 🌻
		</p>
		<p class="mt-10 font-weight-bold text-center text-h5">
			행복이란 무엇일까요?
		</p>
		<v-slide-group show-arrows>
			<ul id="stickies" class="d-flex flex-wrap justify-center">
				<v-slide-item v-for="item in myHappiness" :key="item.title">
					<li>
						<span>{{ item.title }}</span>
						<p>- {{ item.name }}</p>
					</li>
				</v-slide-item>
			</ul>
		</v-slide-group>
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
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hi+Melody&family=Jua&family=Nanum+Pen+Script&family=Stylish&family=Yeon+Sung&display=swap');

#stickies {
	display: flow-root;
}
#stickies li {
	z-index: 1;
	margin: 30px;
	padding: 15px 15px 50px 15px;
	width: 210px;
	height: 210px;
	background-color: rgb(255, 231, 125);
	font-size: 1.4rem;
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
	white-space: break-spaces !important;
}

#stickies li p {
	position: absolute;
	right: 20px;
	bottom: 10px;
}

/* 회전 */
#stickies li:nth-child(even) {
	font-family: 'Nanum Pen Script', cursive;
	-webkit-transform: rotate(2deg);
	-moz-transform: rotate(2deg);
	-o-transform: rotate(2deg);
	-ms-transform: rotate(2deg);
	transform: rotate(2deg);
}

#stickies li:nth-child(odd) {
	font-family: 'Hi Melody', cursive;
	-webkit-transform: rotate(-1deg);
	-moz-transform: rotate(-1deg);
	-o-transform: rotate(-1deg);
	-ms-transform: rotate(-1deg);
	transform: rotate(-1deg);
}

#stickies li:nth-child(3n) {
	font-family: 'Yeon Sung', cursive;
	-webkit-transform: rotate(1deg);
	-moz-transform: rotate(1deg);
	-o-transform: rotate(1deg);
	-ms-transform: rotate(1deg);
	transform: rotate(1deg);
}

#stickies li:hover {
	z-index: 10;
	-webkit-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	-moz-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	-o-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
}
</style>
