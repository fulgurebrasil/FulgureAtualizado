<template>
  <div>
    <b-row>
      <b-col class="right">
        <b-card>
          <h3>Entrar</h3>
          <p class="label instrucao">
            Insira os seus dados para realizar o login.
          </p>
          <b-form @reset="onReset" @submit.prevent="doLogin">
            <p class="label">Nome</p>
            <b-form-input
              class="nome input"
              type="nome"
              placeholder="Insira seu nome"
              v-model="formLogin.username"
              required
            >
            </b-form-input>
            <p class="label">Senha</p>
            <b-form-input
              class="senha input"
              type="password"
              placeholder="••••••••••••••••••"
              v-model="formLogin.password"
              required
            >
            </b-form-input>
            <b-button class="enviar-login" type="submit">Enviar</b-button>
          </b-form>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
  auth: false,
  data() {
    return {
      formLogin: {
        username: '',
        password: '',
      },
    }
  },
  methods: {
    onReset(event) {
      event.preventDefault()
      this.form.nome = ''
      this.form.senha = null
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    async setAuthToken(data) {
      const authHeader = 'Bearer ' + data.token
      // console.log(data.token);
      // console.log(data);
      this.$auth.setUserToken(authHeader, null)
      this.$axios.setHeader('Authorization', authHeader)
      // this.$auth.ctx.app.$axios.setHeader('Authorization', authHeader);
      // const response = await this.$axios.get('/user/me', {
      //     headers:{
      //       'Authorization': authHeader,
      //     }
      //   }
      // )
      const response = await this.$axios.get('/usuario/me')
      this.$auth.setUser(response.data)
      // this.$router.push('/');
    },

    async doLogin() {
      try {
        const response = await this.$axios.post('/login', this.formLogin)

        if (response.data.data.token) {
          await this.setAuthToken(response.data.data)
        }

        if (this.$auth.loggedIn) {
          console.log('Login feito com sucesso.')
          console.log(this.$auth.strategy.token)
          console.log(this.$auth.strategy)
          this.$router.push('/tela-jogar')
        }
      } catch (error) {
        console.log(error)
        alert('Nome ou senha incorretos!')
      }
    },
  },
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=League+Spartan:wght@600&family=Montserrat:wght@300&display=swap');

body {
  background-color: white;
  font-family: 'Montserrat', sans-serif;
  font-size: 16px;
  color: black;
  background-image: url('~/static/fundo.png');
  background-repeat: no-repeat;
  background-size: cover;
}

h3 {
  font-weight: bold;
}

.input,
.enviar-login,
h3 {
  margin-top: 24px;
  margin-bottom: 24px;
}

.enviar-login {
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

.enviar-login:hover {
  background-color: rgba(0, 0, 0, 87%);
}

.label {
  margin-bottom: 14px;
}

.check {
  color: rgb(129, 129, 129);
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

.card {
  height: 100%;
  border: none;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  width: 40%;
  margin: 0 auto;
}

@media only screen and (max-device-width: 900px) {
  body {
    background-color: white;
    background-image: none;
  }

  .card {
    border: none;
    width: 100% !important;
    height: 100% !important;
    box-shadow: none;
  }
}
</style>