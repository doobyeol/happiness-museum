<template>
  <div class="hello">
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
