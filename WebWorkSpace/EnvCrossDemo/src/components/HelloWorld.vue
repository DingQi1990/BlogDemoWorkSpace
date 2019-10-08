<template>
  <div class="hello">
    <h1>{{baseUrl}}</h1>

  </div>
</template>

<script>
  import baseUrl from '../common/js/config'

  export default {
    name: 'HelloWorld',
    data() {
      return {
        baseUrl: ""
      }
    },
    created() {
      this.baseUrl = baseUrl;

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
