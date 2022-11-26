export default {
  // Target: https://go.nuxtjs.dev/config-target
  target: 'static',

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'fulgure-brasil',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' },
    ],
    link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }],
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    '@nuxtjs/eslint-module',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/bootstrap
    'bootstrap-vue/nuxt',
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    // https://go.nuxtjs.dev/pwa
    '@nuxtjs/pwa',
    '@nuxtjs/auth-next'
  ],

  auth: {
    // Options to '@nuxtjs/auth-next' module
    strategies: {
      local: {
        user: {
          autoFetch: false,
        },
        endpoints: {
          login: { url: '/login', method: 'post', propertyName: "data.token"},
          // user: { url: '/user/me', method: 'get'},
          logout: false,
        },
      },
    },
  },

  router:{
    // Define que todas as páginas do app só serão acessíveis se o login tiver sido realizado
    middleware: ["auth"]
  },

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
    baseURL: 'http://localhost:8080/',
  },

  // PWA module configuration: https://go.nuxtjs.dev/pwa
  pwa: {
    meta: {
      title: 'Fulgure Brasil',
      author: 'Alinne Gomes, Giovana Guedes, Alessandra Maia, Laís Keiko',
    },
    manifest: {
      name: "FulgureBrasil",
      short_name: "Fulgure",
      description: "Quiz sobre a cultura brasileira.",
      lang: 'pt-br',
    },
    icon: {
      fileName: 'logo.png',
      sizes: [64, 120, 144, 152, 192, 384, 512],
    }
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {},
}
