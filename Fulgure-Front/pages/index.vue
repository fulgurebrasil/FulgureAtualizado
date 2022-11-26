<template>
  <div>
    <b-row>
      <b-col>
        <b-card class="card-index">
          <h3>Cadastrar</h3>
          <p class="label">Insira os seus dados para realizar o cadastro.</p>
          <p class="instrucao">
            Já possui cadastro? <a href="/tela-login">Clique aqui</a> para
            realizar o login.
          </p>
          <b-form @submit="onSubmit" @reset="onReset">
            <p class="label">Nome</p>
            <b-form-input
              class="nome input"
              type="text"
              placeholder="Seu nome"
              v-model="form.nome"
              required
            >
            </b-form-input>
            <p class="label">Email</p>
            <b-form-input
              class="email input"
              type="email"
              placeholder="example@mail.com"
              v-model="form.email"
              required
            >
            </b-form-input>
            <p class="label">Senha</p>
            <b-form-input
              class="senha input"
              type="password"
              placeholder="••••••••••••••••••"
              v-model="form.senha"
              required
            >
            </b-form-input>
            <b-form-checkbox class="check"
              >Eu li e concordo com os
              <span>termos de uso</span>.</b-form-checkbox
            >
            <b-button
              class="enviar-cadastro"
              type="submit"
              v-on:click="criaCadastro"
              >Enviar</b-button
            >
          </b-form>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
  // Define que essa página está acessível para todo mundo
  auth: false,
  data() {
    return {
      form: {
        nome: '',
        email: '',
        senha: '',
      },
      show: true,
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
      alert(JSON.stringify(this.form))
    },
    onReset(event) {
      event.preventDefault()
      this.form.nome = ''
      this.form.email = ''
      this.form.senha = null
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    criaCadastro() {
      this.$axios.post('/usuario', {
        nome: this.form.nome,
        email: this.form.email,
        senha: this.form.senha,
      })
      this.$router.push('/tela-login')
    },
  },
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=League+Spartan:wght@600&family=Montserrat:wght@300&display=swap');

body {
  background-image: url('~/static/fundo.png');
  background-repeat: no-repeat;
  background-size: cover;
  font-family: 'Montserrat', sans-serif;
  font-size: 16px;
  color: black;
}

h3 {
  font-weight: bold;
}

.input,
.enviar-cadastro,
h3 {
  margin-top: 24px;
  margin-bottom: 24px;
}

.enviar-cadastro {
  height: 44px;
  font-weight: bold;
  width: 100%;
  border: none;
  border-radius: 6px;
  box-shadow: 3px 3px 3px #9b9b9b;
  cursor: pointer;
  background-color: black;
  color: white;
  margin-top: 56px;
}

.enviar-cadastro:hover {
  background-color: rgba(0, 0, 0, 87%);
}

.label {
  margin-bottom: 14px;
}

.check {
  color: rgb(129, 129, 129);
  margin-top: 30px;
}

.check span {
  color: blue;
}

.instrucao {
  margin-bottom: 56px;
}

.row {
  margin: 2%;
  margin-bottom: 4%;
  height: 100%;
}

.card-index {
  height: 100%;
  border: none;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  width: 50%;
  margin: 0 auto;
}

.footer {
  margin-top: 90px;
}
@media only screen and (max-device-width: 900px) {
  body {
    background-image: none;
    background-color: white !important;
  }

  .card-index {
    border: none;
    width: 100%;
    height: 100%;
    box-shadow: none;
  }
}
</style>