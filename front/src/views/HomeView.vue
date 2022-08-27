<template>
	<v-container>
		<v-row>
			<v-col cols="12">
				<p class="font-weight-bold text-center text-h3">
					Welcome To The Happiness Museum 🌻
				</p>
			</v-col>

			<v-col cols="12">
				<p class="font-weight-bold text-center text-h5">행복이란 무엇일까요?</p>
			</v-col>
		</v-row>
		<v-row>
			<div class="stickies d-flex flex-wrap justify-center">
				<VueDragResize
					v-for="item in happinessList"
					:key="item.happiness"
					:isActive="false"
					:preventActiveBehavior="false"
					:isResizable="false"
					:x="setPosition('x')"
					:y="setPosition('y')"
					@clicked="onActivated"
				>
					<span>{{ item.happiness }}</span>
					<p>- {{ item.userNm }}</p>
				</VueDragResize>
			</div>
		</v-row>
	</v-container>
</template>

<script>
import VueDragResize from 'vue-drag-resize';
import { mapGetters, mapActions } from 'vuex';

export default {
	name: 'HomeView',
	components: {
		VueDragResize,
	},
	data() {
		return {
			zIndex: 100,
		};
	},

	computed: {
		...mapGetters({
			happinessList: 'user/getHappinessList',
		}),
	},

	created() {
		this.fetchHappinessList();
	},

	methods: {
		...mapActions({
			fetchHappinessList: 'user/fetchHappinessList',
		}),

		onActivated(event) {
			if (event.target) {
				event.target.style.zIndex = this.zIndex++;
				document.getElementsByClassName('v-app-bar--fixed')[0].style.zIndex =
					this.zIndex + 1;
				document.getElementsByClassName(
					'v-navigation-drawer--temporary',
				)[0].style.zIndex = this.zIndex + 2;
			}
		},

		setPosition(xOrY) {
			const xStart = -100;
			const xEnd = 100;
			const yStart = -50;
			const yEnd = 0;
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
	box-shadow: 2px 2px 8px rgba(170, 146, 38, 0.493);
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
	-webkit-box-shadow: 2px 7px 10px 4px rgba(133, 132, 130, 0.3);
	-moz-box-shadow: 2px 7px 10px 4px rgba(133, 132, 130, 0.3);
	-o-box-shadow: 2px 7px 10px rgba(133, 132, 130, 0.3);
}
</style>
