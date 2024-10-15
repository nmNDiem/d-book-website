import React from 'react';
import { BooleanInput, Edit, ImageField, ImageInput, SimpleForm, TextInput } from 'react-admin';

const UserEdit = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="fullName" />
            <TextInput source="dob" />
            <TextInput source="title" />
            <TextInput source="phone" />
            <TextInput source="address" />
            <BooleanInput source="active" />

            <ImageInput source="avatar" label="Avatar" accept="image/*" placeholder={<p>Tải hình ảnh</p>}>
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Edit>
);

export default UserEdit;