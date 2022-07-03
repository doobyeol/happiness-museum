<template>
  <div class="hello">
    <v-icon
      large
      color="green darken-2"
    >
      mdi-domain
    </v-icon>
    <v-btn
      depressed
      color="primary"
    >
      Hello!
    </v-btn>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>
