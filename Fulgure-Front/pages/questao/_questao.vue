<template>
  <div>
    <itemNav :pontos="usuario.pontos"></itemNav>
    <div>
        <b-progress :value="questao.id" :max="max" :animated="true" :show-value="true" class="mb-3"></b-progress>
    </div>
    <b-button-toolbar key-nav aria-label="Toolbar with button groups" class="toolbar-top">
      <b-button class="left box-btn" id="timer"><img src="~/static/relogio.png" /><span id="timer-span"></span>
      </b-button>
      <b-button class="right box-btn" variant="danger"><img src="~/static/coracao.png" width="20px" height="20px" />{{
          usuario.vidas
      }}</b-button>
    </b-button-toolbar>
    <b-card class="mb-2 box">
      <b-card-title> Questão {{ questao.id }}</b-card-title>
      <b-card-text>
        {{ questao.comando }}
      </b-card-text>
      <b-form-radio-group id="grupo1" v-model="selected">
        <b-form-radio value="a" class="alternativas" name="alternativas">
          {{ questao.alternativas[0] }}
        </b-form-radio>
        <b-form-radio value="b" class="alternativas" name="alternativas">
          {{ questao.alternativas[1] }}
        </b-form-radio>
        <b-form-radio value="c" class="alternativas" name="alternativas">
          {{ questao.alternativas[2] }}
        </b-form-radio>
        <b-form-radio value="d" class="alternativas" name="alternativas">
          {{ questao.alternativas[3] }}
        </b-form-radio>
        <b-form-radio value="e" class="alternativas" name="alternativas">
          {{ questao.alternativas[4] }}
        </b-form-radio>
      </b-form-radio-group>
    </b-card>
    <b-card class="bttns bottom">
      <b-button-toolbar key-nav aria-label="Toolbar with button groups">
        <NuxtLink v-bind:to="`/questao/${questao.id - 1}`">
          <b-button class="left btn seta box-btn">&lsaquo;</b-button>
        </NuxtLink>
        <itemDica :textoDica="questao.dica"></itemDica>
        <b-button class="enviar btn box-btn" @click="validarResposta">Enviar</b-button>
        <itemPular></itemPular>
        <NuxtLink v-bind:to="`/questao/${questao.id + 1}`">
          <b-button class="right btn seta box-btn">&rsaquo;</b-button>
        </NuxtLink>
        <itemCuriosidade :textoCuriosidade="questao.curiosidade"></itemCuriosidade>
      </b-button-toolbar>
    </b-card>
    <itemFooter></itemFooter>
  </div>
</template>

<script>

import itemNav from '~/components/itemNav.vue'
import itemFooter from '~/components/itemFooter.vue'
import itemDica from '~/components/itemDica.vue'
import itemPular from '~/components/itemPular.vue'
import itemCuriosidade from '~/components/itemCuriosidade.vue'

export default {
  components: {
    itemNav,
    itemFooter,
    itemDica,
    itemPular,
    itemCuriosidade,
  },
  auth: false,

  async asyncData({ $axios, route }) {
    const idQuestao = route.params.questao
    const resposta = await $axios.get('/questao/' + idQuestao)
    const questao = resposta.data
    const response = await $axios.get('/usuario/me')
    const usuario = response.data
    const questoes = await $axios.get('/questao/')
    const max = questoes.data.length

    return { questao, usuario, max}
  },

  data() {
    return {
      selected: '',
    }
  },

  methods: {
    async setVidas() {
      const url = '/questao/' + (this.questao.id + 1)
      await this.$axios.$put('/usuario/' + this.usuario.nome, {
        vidas: this.usuario.vidas - 1,
      })
      window.location.href = url
    },

    async setPontuacao() {
      await this.$axios.$put('/usuario/' + this.usuario.nome, {
        pontos: this.usuario.pontos + this.questao.pontuacao,
      })
    },
    startTimer() {
      const tempo = 120
      const duration = tempo
      const display = document.querySelector('#timer-span')
      let timer = duration
      let minutes, seconds
      const a = this.setVidas
      setInterval(function () {
        minutes = parseInt(timer / 60, 10)
        seconds = parseInt(timer % 60, 10)
        minutes = minutes < 10 ? '0' + minutes : minutes
        seconds = seconds < 10 ? '0' + seconds : seconds
        display.textContent = minutes + ':' + seconds
        if (--timer < 0) {
          a()
        }
      }, 1000)
    },
    // VALIDAR RESPOSTA E COMPUTAR PONTUAÇÃO E COLOCAR CURIOSIDADE DPS DE VALIDAÇÃO
    validarResposta() {
      const res = this.selected
      const a = this.setPontuacao
      const url = '/questao/' + (this.questao.id + 1)
      this.$bvModal.show('modal-3')
      if (res === this.questao.resposta) {
        alert('Resposta correta!')
        a()
      } else {        
        alert('Resposta incorreta!')
      }
      setInterval(function (){window.location.href = url},5000)
    },
  },
  // Chama a função depois que a página é carregada
  mounted() {
    this.startTimer()
  },
}
</script>

<style>
* {
  width: auto;
  height: auto;
  box-sizing: border-box;
  text-align: justify;
}

img {
  width: 24px;
  height: 24px;
}

body {
  height: 100%;
  background-image: none !important;
}

.nav {
  margin-bottom: 0;
}

.card {
  width: 80%;
  margin: 0 auto;
}

.alternativas {
  display: block;
}

.btn-toolbar {
  display: flex;
  justify-content: center;
  margin-top: 25px;
  width: 100%;
}

.toolbar-top {
  display: flex;
  margin-bottom: 20px;
  justify-content: space-between;
  width: 80%;
  margin: 0 auto;
  margin-bottom: 40px;
  margin-top: 40px;
}

.enviar {
  margin: 0 5px;
  background-color: rgb(0, 137, 9);
}

.bttns {
  border: none;
}

.start {
  display: flex;
  justify-content: flex-start;
}

.end {
  display: flex;
  justify-content: flex-end;
}

.toolbar-top .left {
  display: inline-block;
  flex-direction: left;
}

.toolbar-top .right {
  float: right;
}

.toolbar-top .left img {
  margin-right: 5px;
}

.btn-toolbar {
  height: 100%;
}

.bottom .left {
  margin-right: 10px;
}

.bottom .right {
  margin-left: 10px;
}

.seta {
  background-color: #007bff;
}

.seta:hover {
  background-color: #0766cc;
}

.enviar:hover {
  background-color: rgb(3, 110, 10);
}

.btn {
  border: none;
}

.inferior {
  margin: 0 20px;
}

.box {
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px !important;
}

.box-btn {
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.footer {
  margin-top: 200px;
}

#timer {
  background-color: transparent;
  display: block;
  color: black;
  cursor: default;
}

@media only screen and (max-device-width: 500px) {
  .card {
    border: none;
    width: 100%;
    box-shadow: none !important;
  }

  .footer {
    margin-top: 50px;
  }

  .toolbar-top {
    width: 90%;
  }
}
</style>
