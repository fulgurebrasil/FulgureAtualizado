<template>
  <div class="footer">
    <b-footer
      class="text-center text-lg-start bg-light text-muted"
      id="b-footer"
    >
      <section
        class="
          bottom
          d-flex
          justify-content-center justify-content-lg-between
          p-4
          border-bottom border-top
        "
      >
        <div class="mensagem me-5 d-none d-lg-block">
          <span>Acompanhe-nos nas redes sociais:</span>
        </div>
        <div class="images">
          <a href="" class="me-4 text-reset">
            <i class="fab fa-google">
              <img src="~/static/google.png" class="social" />
            </i>
          </a>
          <a href="" class="me-4 text-reset">
            <i class="fab fa-instagram">
              <img src="~/static/instagram.png" class="social" />
            </i>
          </a>
          <a href="" class="me-4 text-reset">
            <i class="fab fa-github">
              <img src="~/static/github.png" class="social" />
            </i>
          </a>
        </div>
      </section>
      <div
        class="text-center p-4"
        style="background-color: rgba(0, 0, 0, 0.05)"
      >
        <p class="text-reset fw-bold">
          Desenvolvido por: Alessandra Maia, Alinne Gomes, Giovana Guedes e Laís
          Keiko
        </p>
      </div>
    </b-footer>
  </div>
</template>


<style>
@import url('https://fonts.googleapis.com/css2?family=League+Spartan:wght@600&family=Montserrat:wght@300&display=swap');
.footer {
  background-color: white !important;
}
.social {
  width: 24px;
  height: 24px;
}
.me-4 {
  margin-right: 15px;
}
.bottom {
  background-color: transparent;
}
.fw-bold {
  text-align: center;
}
#b-footer {
  width: 100%;
  vertical-align: baseline;
}
@media only screen and (max-device-width: 700px) {
  #b-footer {
    position: relative;
    bottom: 0;
  }
}
</style>