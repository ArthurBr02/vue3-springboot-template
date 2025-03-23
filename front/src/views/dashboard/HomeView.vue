<script>
import DefaultPageContent from '@/components/template/DefaultPageContent.vue';

export default {
    components: {
        DefaultPageContent
    }
}
</script>

<template>
    <DefaultPageContent title="dashboard.title">
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 p-5">
            <Card title="Card 1" class="h-full">
                <template #header>
                    <span>Header</span>
                </template>
                <template #content>
                    <p>Content 1</p>
                </template>
                <template #footer>
                    <span>Footer</span>
                </template> 
            </Card>
            <Card title="Card 2" class="h-full">
                <template #header>
                    <span>Header</span>
                </template>
                <template #content>
                    <p>Content 2</p>
                </template>
                <template #footer>
                    <span>Footer</span>
                </template>
            </Card>
            <Card title="Card 3" class="h-full">
                <template #header>
                    <span>Header</span>
                </template>
                <template #content>
                    <p>Content 3</p>
                </template>
                <template #footer>
                    <span>Footer</span>
                </template>
            </Card>
            <Card title="Card 4" class="h-full">
                <template #header>
                    <span>Header</span>
                </template>
                <template #content>
                    <p>Content 4</p>
                </template>
                <template #footer>
                    <span>Footer</span>
                </template>
            </Card>
            <Card title="Card 5" class="h-full">
                <template #header>
                    <span>Header</span>
                </template>
                <template #content>
                    <p>Content 5</p>
                </template>
                <template #footer>
                    <span>Footer</span>
                </template>
            </Card>
            <Card title="Card 6" class="h-full">
                <template #header>
                    <span>Header</span>
                </template>
                <template #content>
                    <p>Content 6</p>
                </template>
                <template #footer>
                    <span>Footer</span>
                </template>
            </Card>
        </div>
    </DefaultPageContent>
</template>