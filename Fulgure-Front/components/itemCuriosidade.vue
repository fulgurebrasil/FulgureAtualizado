<template>
    <div>
        <b-modal id="modal-3" title="Curiosidade">
            <p class="my-4">{{ textoCuriosidade }}</p>
            <template #modal-footer="{}">
                <b-button variant="primary">
                    OK
                </b-button>
            </template>
        </b-modal>
    </div>
</template>

<script>
export default {
    props: ["textoCuriosidade"]
}
</script>

<style>

</style>