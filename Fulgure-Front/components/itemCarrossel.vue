<template>
    <div>
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="4000"
        controls
        indicators
        background="#ababab"
        img-height="250"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >
        <!-- Slides with image only -->
        <b-carousel-slide img-src="~/static/slide1.jpg"></b-carousel-slide>
        <b-carousel-slide img-src="~/static/slide2.jpg"></b-carousel-slide>
        <b-carousel-slide img-src="~/static/slide3.jpg"></b-carousel-slide>
        <b-carousel-slide img-src="~/static/slide4.jpg"></b-carousel-slide>
        <b-carousel-slide img-src="~/static/slide5.jpg"></b-carousel-slide>
  
      </b-carousel>
    </div>
  </template>
  
  <script>
    export default {
      methods: {
        onSlideStart(slide) {
          this.sliding = true
        },
        onSlideEnd(slide) {
          this.sliding = false
        }
      }
    }
  </script>
  <style>

  </style>