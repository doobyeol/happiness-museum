<template>
	<v-container class="mainWrap">
		<p class="mt-10 font-weight-bold text-center text-h3">
			Welcome To The Happiness Museum 🌻
		</p>
		<p class="mt-10 font-weight-bold text-center text-h5">
			행복이란 무엇일까요?
		</p>
		<div class="stickies d-flex flex-wrap justify-center">
			<VueDragResize
				:isActive="false"
				:preventActiveBehavior="false"
				:isResizable="false"
				@clicked="onActivated"
				v-for="item in myHappiness"
				:key="item.title"
			>
				<span>{{ item.title }}</span>
				<p>- {{ item.name }}</p>
			</VueDragResize>
		</div>
	</v-container>
</template>

<script>
import VueDragResize from 'vue-drag-resize';

export default {
	name: 'HelloLeaf',
	components: {
		VueDragResize,
	},
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
			zIndex: 0,
		};
	},
	methods: {
		onActivated(event) {
			event.target.style.zIndex = this.zIndex++;
		},

		setPosition(xOrY) {
			const xStart = 40;
			const xEnd = 880;
			const yStart = 100;
			const yEnd = 200;
			let result = 0;

			if (xOrY == 'x') {
				result = Math.random() * (xEnd - xStart) + xStart;
			} else {
				result = Math.random() * (yEnd - yStart) + yEnd;
			}

			return result;
		},
	},
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hi+Melody&family=Jua&family=Nanum+Pen+Script&family=Stylish&family=Yeon+Sung&display=swap');

html {
	overflow-y: auto !important;
}

.mainWrap {
	height: calc(100vh - 64px);
}

.vdr,
.vdr.active:before {
	position: relative !important;
}

.vdr.active:before {
	outline: none !important;
	position: absolute;
}

.stickies {
	display: flow-root;
	position: relative;
}
.stickies .content-container {
	z-index: 1;
	padding: 15px 15px 50px 15px;
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

.stickies .content-container p {
	position: absolute;
	right: 20px;
	bottom: 10px;
}

/* 회전 */
.stickies .vdr:nth-child(even) .content-container {
	font-family: 'Nanum Pen Script', cursive;
	-webkit-transform: rotate(2deg);
	-moz-transform: rotate(2deg);
	-o-transform: rotate(2deg);
	-ms-transform: rotate(2deg);
	transform: rotate(2deg);
}

.stickies .vdr:nth-child(odd) .content-container {
	font-family: 'Hi Melody', cursive;
	-webkit-transform: rotate(-1deg);
	-moz-transform: rotate(-1deg);
	-o-transform: rotate(-1deg);
	-ms-transform: rotate(-1deg);
	transform: rotate(-1deg);
}

.stickies .vdr:nth-child(3n) .content-container {
	font-family: 'Yeon Sung', cursive;
	-webkit-transform: rotate(1deg);
	-moz-transform: rotate(1deg);
	-o-transform: rotate(1deg);
	-ms-transform: rotate(1deg);
	transform: rotate(1deg);
}

.stickies .content-container:hover {
	cursor: pointer;
	-webkit-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	-moz-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
	-o-box-shadow: 2px 12px 10px rgba(133, 132, 130, 0.459);
}
</style>
