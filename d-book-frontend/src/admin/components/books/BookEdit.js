import React from 'react';
import { BooleanInput, Edit, ImageField, ImageInput, ReferenceInput, SelectInput, SimpleForm, TextInput } from 'react-admin';

const BookEdit = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="title" />
            <TextInput source="pages" />
            <TextInput source="isbn" />
            <TextInput source="description" />
            <TextInput source="price" />
            <TextInput source="discountPercent" />
            <TextInput source="rating" />
            <TextInput source="stock" />
            <BooleanInput source="active" />

            <ReferenceInput source="categoryId" reference="categories" label="Category">
                <SelectInput optionText="name" />
            </ReferenceInput>

            <ReferenceInput source="authorId" reference="authors" label="Author">
                <SelectInput optionText="name" />
            </ReferenceInput>
            
            <ReferenceInput source="publisherId" reference="publishers" label="Publisher">
                <SelectInput optionText="name" />
            </ReferenceInput>
    
            <ImageInput source="image" label="Image" accept="image/*" placeholder={<p>Tải hình ảnh</p>}>
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Edit>
);

export default BookEdit;