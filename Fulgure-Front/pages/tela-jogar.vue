<template>
  <div>
    <itemNav class="nav"></itemNav>
    <b-container class="bv-example-row">
      <b-row>
        <b-col>
          <b-jumbotron>
            <h1>Fulgure, Brasil!</h1>
            <p>
              Lorem Ipsum is simply dummy text of the printing and typesetting
              industry. Lorem Ipsum has been the industry's standard dummy text
              ever since the 1500s, when an unknown printer took a galley of
              type and scrambled it to make a type specimen book. It has
              survived not only five centuries, but also the leap into
              electronic typesetting, remaining essentially unchanged. It was
              popularised in the 1960s with the release of Letraset sheets
              containing Lorem Ipsum passages, and more recently with desktop
              publishing software like Aldus PageMaker including versions of
              Lorem Ipsum.
            </p>
            <itemCarrossel></itemCarrossel>
          </b-jumbotron>
        </b-col>
        <b-col>
          <b-card title="Fácil" class="facil mb-2">
            <b-card-text>
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
            </b-card-text>

            <b-button href="/questao/1" class="bttn">Jogar</b-button>
          </b-card>
          <b-card title="Médio" class="medio mb-2">
            <b-card-text>
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
            </b-card-text>

            <b-button href="/questao/6" class="bttn">Jogar</b-button>
          </b-card>
          <b-card title="Difícil" class="dificil mb-2">
            <b-card-text>
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
            </b-card-text>
            <b-button href="/questao/11" class="bttn">Jogar</b-button>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
    <itemFooter></itemFooter>
  </div>
</template>

<script>
import itemNav from '~/components/itemNav.vue'
import itemCarrossel from '~/components/itemCarrossel.vue'
import itemFooter from '~/components/itemFooter.vue'

export default {
  components: { itemNav, itemFooter, itemCarrossel },
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ['auth'],
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=League+Spartan:wght@600&family=Montserrat:wght@300&display=swap');

* {
  width: auto;
  height: auto;
  box-sizing: border-box;
  text-align: justify;
}

.mb-2 {
  height: auto !important;
  width: auto;
}

body {
  background-image: url('~/static/fundo.png');
  background-repeat: no-repeat;
  background-size: cover;
}

.card {
  border-radius: 5px;
  border-color: transparent;
}

.jumbotron,
.col {
  margin: 0;
}

.col {
  margin-top: 20px;
}

.jumbotron {
  background-color: #ffff;
  padding: 40px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px,
    rgba(0, 0, 0, 0.3) 0px 30px 60px -30px;
}

.bttn {
  border-color: transparent;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px,
    rgba(0, 0, 0, 0.3) 0px 30px 60px -30px;
  color: white;
}

.bttn:hover {
  background-color: white;
  font-weight: bolder;
  border-color: transparent;
  color: white;
}

.facil .bttn {
  background-color: green;
}
.medio .bttn {
  background-color: rgb(233, 191, 52);
}
.dificil .bttn {
  background-color: rgb(53, 128, 199);
}

.footer {
  margin-top: 50px;
}

@media only screen and (max-device-width: 900px) {
  .row {
    display: block;
  }
}
</style>