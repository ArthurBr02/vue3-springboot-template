<script>
export default {
    props: {
        title: {
            type: String,
            required: true
        }
    }
}
</script>

<template>
    <div class="flex flex-col">
        <div class="pt-3 pb-5 flex justify-center w-lvw bg-white shadow">
            <span class="text-4xl text-center font-medium">{{ $t(title) }}</span>
        </div>
        <slot></slot>
    </div>
</template>